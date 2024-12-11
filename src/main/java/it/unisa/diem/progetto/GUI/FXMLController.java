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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
         
         private Rubrica rubrica;
         
         private Contatto contattoSelezionato;
    @FXML
    private Button eliminaPulsante;
    @FXML
    private Label idDatabase;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica(new Database());
        
        if (rubrica.visualizzaListaContattiCognome() != null) {
            contatti = FXCollections.observableArrayList(rubrica.visualizzaListaContattiCognome());
            contattiTabella.setItems(contatti);
            nomeColonna.setCellValueFactory(new PropertyValueFactory<>("nome"));
            cognomeColonna.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        } else {
            System.out.println("Errore: contattiTabella è null!");
        }
        
        // Aggiungi un listener alla selezione della TableView
        contattiTabella.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Mostra i dettagli del contatto selezionato
            visualizzaDettagliContatto(newValue);
        });  
    }

    @FXML
    private void switchToAddScene(javafx.event.ActionEvent event) throws IOException{
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
        
        aggiungiStage.showAndWait();
    }
    
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }
    
    void aggiornaTabella() {
    // Ricarica i dati dal database
        contatti.setAll(rubrica.visualizzaListaContattiCognome());
    }

    @FXML
    private void chiudiVisualizzazione(javafx.event.ActionEvent event) {
        visualizzaContattoPane.setVisible(false);
    }
    
    private void visualizzaDettagliContatto(Contatto contatto) {
        this.contattoSelezionato=contatto;
        if (this.contattoSelezionato == null) { // Controlla se il contatto è null
            System.out.println("Il contatto è: " + contatto);
            return;
        }
        
        cognomeLabel.setText(contatto.getCognome());
        nomeLabel.setText(contatto.getNome());
        
        primoTelefonoLabel.setText(contatto.getNumTelefono1());
        secondoTelefonoLabel.setText(contatto.getNumTelefono2());
        terzoTelefonoLabel.setText(contatto.getNumTelefono3());
        primaMailLabel.setText(contatto.getEMail1());
        secondaMailLabel.setText(contatto.getEMail2());
        terzaMailLabel.setText(contatto.getEMail3());
        
        //idDatabase.setText(contatto.getId());
        
        visualizzaContattoPane.setVisible(true);
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
        
        Stage aggiungiStage = new Stage();
        aggiungiStage.setTitle("Modifica Contatto");
        aggiungiStage.initModality(Modality.APPLICATION_MODAL);
        aggiungiStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        aggiungiStage.setScene(new Scene(root));
        
        aggiungiStage.showAndWait();
    }

    @FXML
    private void eliminaContattoRubrica(javafx.event.ActionEvent event) {
        Contatto selectedContact = contattiTabella.getSelectionModel().getSelectedItem();
        System.out.println("aiuto");
        rubrica.eliminaContattoCognomeRubrica(selectedContact);
        System.out.println("aiuto");
        rubrica.eliminaContatto(selectedContact);
    }
    
    
}
