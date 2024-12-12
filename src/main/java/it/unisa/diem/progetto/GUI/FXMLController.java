/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.rubrica.Contatto;
import it.unisa.diem.progetto.rubrica.Rubrica;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rosap
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField searchBar;
    @FXML
    private Button plusPulsante;
    @FXML
    private TableView<Contatto> contattiTabella;
    @FXML
    private TableColumn<Contatto, String> nomeColonna;
    @FXML
    private TableColumn<Contatto, String> cognomeColonna;
    @FXML
    private TableView<Contatto> altContattiTabella;
    @FXML
    private TableColumn<Contatto, String> altNomeColonna;

    @FXML
    private Button cercaPulsante;
    @FXML
    private AnchorPane visualizzaContattoPane;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;
    @FXML
    private Label primoTelefonoLabel;
    @FXML
    private Label secondoTelefonoLabel;
    @FXML
    private Label terzoTelefonoLabel;
    @FXML
    private Label primaMailLabel;
    @FXML
    private Label secondaMailLabel;
    @FXML
    private Label terzaMailLabel;

    private ObservableList<Contatto> contatti;

    private ObservableList<Contatto> altContatti;

    private Rubrica rubrica;

    private Contatto contattoSelezionato;

    @FXML
    private Button eliminaPulsante;
    @FXML
    private Label idDatabase;
    @FXML
    private Button aggiornaPulsante;
    @FXML
    private Button cancellaTuttoPulsante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica(new Database());

        //tabella cognome-nome
        contatti = FXCollections.observableArrayList(rubrica.visualizzaListaContattiCognome());
        contattiTabella.setItems(contatti);
        nomeColonna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cognomeColonna.setCellValueFactory(new PropertyValueFactory<>("cognome"));

        //tabella nome
        altContatti = FXCollections.observableArrayList(rubrica.visualizzaListaContattiNome());
        altContattiTabella.setItems(altContatti);
        altNomeColonna.setCellValueFactory(new PropertyValueFactory<>("nome"));

        // Listener alla selezione della TableView contattiTabella
        contattiTabella.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Deseleziona la selezione in altContattiTabella
            if (newValue != null) {
                altContattiTabella.getSelectionModel().clearSelection();
            }
            // Mostra i dettagli del contatto selezionato
            visualizzaDettagliContatto(newValue);
        });

        // Listener alla selezione della TableView altContattiTabella
        altContattiTabella.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Deseleziona la selezione in contattiTabella
            if (newValue != null) {
                contattiTabella.getSelectionModel().clearSelection();
            }
            // Mostra i dettagli del contatto selezionato
            visualizzaDettagliContatto(newValue);
        });

    }

    @FXML
    private void switchToAddScene(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Aggiungi.fxml"));
        Parent root = loader.load();

        //Ottengo il controller della finestra Aggiunta
        AggiungiController aggiungiController = loader.getController();
        aggiungiController.setRubrica(rubrica);

        //imposto FXML come controller principale
        aggiungiController.setFXMLController(this);

        Stage aggiungiStage = new Stage();
        aggiungiStage.setTitle("Aggiungi Contatto");
        aggiungiStage.initModality(Modality.APPLICATION_MODAL);
        aggiungiStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        aggiungiStage.setScene(new Scene(root));
        
        contattiTabella.getSelectionModel().clearSelection();
        
        altContattiTabella.getSelectionModel().clearSelection();
        
        visualizzaContattoPane.setVisible(false);

        aggiungiStage.showAndWait();
    }

    public ObservableList<Contatto> getContatti() {
        return contatti;
    }

    void aggiornaTabella() {
        // Ricarica i dati dal database
        contatti.setAll(rubrica.visualizzaListaContattiCognome());
        altContatti.setAll(rubrica.visualizzaListaContattiNome());
    }

    @FXML
    private void chiudiVisualizzazione(javafx.event.ActionEvent event) {

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

    }

    private void visualizzaDettagliContatto(Contatto contatto) {
        this.contattoSelezionato = contatto;

        if (this.contattoSelezionato == null || contatto.getId() <= 0) {
            System.out.println("Contatto non valido o senza ID");
            return;
        }

        int contactId = contatto.getId();
        System.out.println("ID del contatto selezionato: " + contactId);

        // Recupera i dettagli dal database
        Contatto contattoRecuperato = rubrica.getContattoById(contactId);

        if (contattoRecuperato != null) {
            cognomeLabel.setText(contattoRecuperato.getCognome());
            nomeLabel.setText(contattoRecuperato.getNome());
            primoTelefonoLabel.setText(contattoRecuperato.getNumTelefono1());
            secondoTelefonoLabel.setText(contattoRecuperato.getNumTelefono2());
            terzoTelefonoLabel.setText(contattoRecuperato.getNumTelefono3());
            primaMailLabel.setText(contattoRecuperato.getEMail1());
            secondaMailLabel.setText(contattoRecuperato.getEMail2());
            terzaMailLabel.setText(contattoRecuperato.getEMail3());

            idDatabase.setText(String.valueOf(contactId)); // Visualizza l'ID del contatto

            visualizzaContattoPane.setVisible(true);
        } else {
            System.out.println("Contatto non trovato nel database.");
        }
    }

    @FXML
    private void switchToSceneModify(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifica.fxml"));
        Parent root = loader.load();

        //Ottengo il controller della finestra Aggiunta
        ModificaController modificaController = loader.getController();
        modificaController.setRubrica(rubrica);

        //imposto FXML come controller principale
        modificaController.setFXMLController(this);

        // Passa il contatto selezionato al controller della finestra Modifica
        modificaController.setContatto(contattoSelezionato);

        //Passa il riferimento della ObservableList
        modificaController.setObservableList(contatti);

        Stage aggiungiStage = new Stage();
        aggiungiStage.setTitle("Modifica Contatto");
        aggiungiStage.initModality(Modality.APPLICATION_MODAL);
        aggiungiStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        aggiungiStage.setScene(new Scene(root));
        
        contattiTabella.getSelectionModel().clearSelection();
        
        altContattiTabella.getSelectionModel().clearSelection();
        
        visualizzaContattoPane.setVisible(false);

        aggiungiStage.showAndWait();
    }

    @FXML
    private void eliminaContattoRubrica(javafx.event.ActionEvent event) {
        Contatto selectedContact = contattiTabella.getSelectionModel().getSelectedItem();
        Contatto altSelectedContact = altContattiTabella.getSelectionModel().getSelectedItem();
        
        
        if (selectedContact == null) {
            //per tabella nome
            int altContactId = altSelectedContact.getId(); // Ottieni l'ID dal contatto
            System.out.println("Eliminazione contatto solo nome con ID: " + altContactId);

            rubrica.eliminaContatto(altSelectedContact); // Elimina dal database usando l'ID
            altContatti.remove(altSelectedContact);
            
        }else if (altSelectedContact == null) {
            
            //per tabella cognome-nome
            int contactId = selectedContact.getId(); // Ottieni l'ID dal contatto
            System.out.println("Eliminazione contatto con cognome con ID: " + contactId);

            rubrica.eliminaContatto(selectedContact); // Elimina dal database usando l'ID
            contatti.remove(selectedContact);
            
        }
        
        
        
        
    }

    void setSearchBar(String string) {
        searchBar.setText(string);
    }

    @FXML
    private void premiRicerca(javafx.event.ActionEvent event) {

        if (searchBar.getText().trim().isEmpty()) {
            contatti.setAll(rubrica.visualizzaListaContattiCognome());
            altContatti.setAll(rubrica.visualizzaListaContattiNome());
            return;
        }

        List<Contatto> list = new ArrayList<>();
        List<Contatto> contattiCognome = new ArrayList<>();
        List<Contatto> contattiNome = new ArrayList<>();
        list = rubrica.ricercaContatto(searchBar.getText().trim());

        for (Contatto c : list) {

            if (c.getCognome() != "") {
                contattiCognome.add(c);
            } else {
                contattiNome.add(c);
            }

        }

        contatti.setAll(rubrica.visualizzaListaContattiCognome(contattiCognome));
        altContatti.setAll(rubrica.visualizzaListaContattiNome(contattiNome));

    }

    @FXML
    private void aggiornaListe(javafx.event.ActionEvent event) {
        contatti.setAll(rubrica.visualizzaListaContattiCognome());
        altContatti.setAll(rubrica.visualizzaListaContattiNome());
    }

    @FXML
    private void cancellaTuttiIContatti(javafx.event.ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ATTENZIONE");
        alert.setHeaderText("Vuoi eliminare tutti i contatti salvati?");
        alert.setContentText("Questa operazione non è reversibile");

        ButtonType buttonTypeYes = new ButtonType("Sì");
        alert.initModality(Modality.APPLICATION_MODAL);

        alert.getButtonTypes().setAll(buttonTypeYes, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == buttonTypeYes) {
                // fai visualizzare la lista
                rubrica.eliminaTuttiContatti();
                aggiornaListe(event);
                return;

            } else if (result.get() == ButtonType.CANCEL) {
                // Non fare nulla, l'alert si chiude automaticamente
                alert.close();

            }
        }
    }

}
