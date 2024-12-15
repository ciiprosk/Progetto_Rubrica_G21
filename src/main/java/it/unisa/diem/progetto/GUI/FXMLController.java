
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.exception.InvalidContactException;
import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.rubrica.Contatto;
import it.unisa.diem.progetto.rubrica.Rubrica;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *  Classe principale della rubrica, è possibile: 
 * 1. Visualizzare la rubrica in due liste ordinate--> per cognome se i contatti ne anno uno, altrimenti per nome
 * 2. Ricercare contatti 
 * 3. Aggiornare la lista--> utilizzato nel caso in cui più persone stanno utilizzando l'applicazione e fanno modifiche
 * 4. Aggiungere contatti
 * 5. Modificare i contatti esistenti
 * 6. Cancellare tutti i contatti
 * 7. Importare/Esportare Contatti
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
    private ProgressIndicator progressIndicator;

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
    @FXML
    private MenuItem importaPulsante;
    @FXML
    private MenuItem esportaPulsante;

    /**
     * @brief inizializza il controller
     * 
     * Assegna le table view, listner e dati iniziali
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica(new Database("rubrica"));

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

    
    /**
     * @brief apre la scheda Aggiungi.fxml
     * 
     * @param event
     * @throws IOException 
     */
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
        aggiungiStage.getIcons().add(new Image(getClass().getResourceAsStream("aggiungi.png")));
        aggiungiStage.initModality(Modality.APPLICATION_MODAL);
        aggiungiStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        aggiungiStage.setScene(new Scene(root));

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

        aggiungiStage.showAndWait();
    }

    /**
     * @brief restituisce la lista osservabile dei contatti
     * 
     * @return ObservableList
     */
    public ObservableList<Contatto> getContatti() {
        return contatti;
    }

    /**
     * @brief aggiorna la tabella dei contatti con gli ultimi dati
     */
    void aggiornaTabella() {
        // Ricarica i dati dal database
        contatti.setAll(rubrica.visualizzaListaContattiCognome());
        altContatti.setAll(rubrica.visualizzaListaContattiNome());
    }

    /**
     * @brief nasconde la visualizzazione dell'AnchorPane di destra
     * 
     * @param event 
     */
    @FXML
    private void chiudiVisualizzazione(javafx.event.ActionEvent event) {

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

    }

    
    /**
     * @brief mostra le informazioni per il contatto selezionato nell'AnchorPAne di destra
     * 
     * @param contatto 
     */
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

    /**
     * @brief apre la scheda Modifica.fxml
     * 
     * @param event
     * @throws IOException 
     */
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
        aggiungiStage.getIcons().add(new Image(getClass().getResourceAsStream("addIcon.png")));
        aggiungiStage.initModality(Modality.APPLICATION_MODAL);
        aggiungiStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        aggiungiStage.setScene(new Scene(root));

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

        aggiungiStage.showAndWait();
    }

    /**
     * @brief elimina un contatto dalla rubrica e dalla visualizzazione
     * 
     * @param event 
     */
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

        } else if (altSelectedContact == null) {

            //per tabella cognome-nome
            int contactId = selectedContact.getId(); // Ottieni l'ID dal contatto
            System.out.println("Eliminazione contatto con cognome con ID: " + contactId);

            rubrica.eliminaContatto(selectedContact); // Elimina dal database usando l'ID
            contatti.remove(selectedContact);

        }

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);
    }

    /**
     * @brief imposta il testo della searchBar
     * 
     * @param string 
     */
    void setSearchBar(String string) {
        searchBar.setText(string);
    }

    /**
     * @brief gesisce l'azione di ricerca dei contatti
     * 
     * esegue una ricerca basata sul testo nel textField
     * in caso di barra vuota visualizza tutti i contatti
     * 
     * @param event 
     */
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

            if (c.getCognome().equals("")) {
                contattiNome.add(c);
            } else {
                contattiCognome.add(c);
            }

        }

        contatti.setAll(contattiCognome);
        altContatti.setAll(contattiNome);
        searchBar.setText("");

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

    }
    
    /**
     * @brief aggiorna le liste dei contatti
     * 
     * @param event 
     */
    @FXML
    private void aggiornaListe(javafx.event.ActionEvent event) {
        contatti.setAll(rubrica.visualizzaListaContattiCognome());
        altContatti.setAll(rubrica.visualizzaListaContattiNome());
        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();
        visualizzaContattoPane.setVisible(false);

    }

    /**
     * @brief cancella tutti i contatti presenti nella rubrica
     * 
     * verifica se ci sono contatti da eliminare e richiede conferma prima di eliminare
     * 
     * @param event 
     */
    @FXML
    private void cancellaTuttiIContatti(javafx.event.ActionEvent event) {
        if (rubrica.visualizzaListaContattiNome().isEmpty() && rubrica.visualizzaListaContattiCognome().isEmpty()) {

            // Mostra un messaggio di errore
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Errore");
            errorAlert.setHeaderText("Impossibile cancellare");
            errorAlert.setContentText("Non ci sono contatti da eliminare.");
            Stage alertStage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(new Image(this.getClass().getResource("alerticon.png").toString()));
            
            // Carica il file CSS
            errorAlert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());
            
            errorAlert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ATTENZIONE");
        alert.setHeaderText("Vuoi eliminare tutti i contatti salvati?");
        alert.setContentText("Questa operazione non è reversibile");
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(this.getClass().getResource("alerticon.png").toString()));

        // Carica il file CSS
        alert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());

        ButtonType buttonTypeYes = new ButtonType("Sì");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setGraphic(null);
        alert.getButtonTypes().setAll(buttonTypeYes, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == buttonTypeYes) {

                rubrica.eliminaTuttiContatti();
                aggiornaListe(event);

            } else if (result.get() == ButtonType.CANCEL) {

                alert.close();

            }
        }

        contattiTabella.getSelectionModel().clearSelection();

        altContattiTabella.getSelectionModel().clearSelection();

        visualizzaContattoPane.setVisible(false);

    }
    
    /**
     * @brief importa rubrica da un file CSV
     * 
     * chiede conferma prima di sovrascrivere la rubrica corrente
     * 
     * @param event 
     */
    @FXML
    private void importaRubrica(javafx.event.ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ATTENZIONE");
        alert.setHeaderText("L'importazione di una rubrica implica la perdita della rubrica esistente! Sei sicuro"
                + " di voler sovrascrivere la tua rubrica?");
        alert.setContentText("Questa operazione non è reversibile");

        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(this.getClass().getResource("alerticon.png").toString()));

        // Carica il file CSS
        alert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());

        ButtonType buttonTypeYes = new ButtonType("Sì");
        alert.initModality(Modality.APPLICATION_MODAL);

        alert.getButtonTypes().setAll(buttonTypeYes, ButtonType.CANCEL);
        alert.setGraphic(null);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeYes) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleziona un file CSV da importare");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("File CSV", "*.csv")
            );

            Window window = ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            File file = fileChooser.showOpenDialog(window);

            if (file != null) {
                // Mostra il ProgressIndicator
                progressIndicator.setVisible(true);

                // Task per eseguire l'importazione in background
                Task<Void> task = new Task<Void>() { // Tipo generico specificato esplicitamente
                    @Override
                    protected Void call() throws Exception {
                        try {
                            List<Contatto> contattiImportati = rubrica.verificaContattiDaFile(file);

                            if (!contattiImportati.isEmpty()) {
                                // Rimuove i contatti solo dopo aver verificato la validità
                                rubrica.eliminaTuttiContatti();

                                for (Contatto contatto : contattiImportati) {
                                    rubrica.aggiungiContatto(contatto);
                                }

                                System.out.println("Rubrica importata con successo da: " + file.getAbsolutePath());
                            } else {
                                System.out.println("Il file selezionato non contiene contatti validi.");
                            }
                        } catch (InvalidContactException e) {
                            // Log dell'errore per debugging
                            System.err.println("Errore durante la verifica dei contatti: " + e.getMessage());
                            // Solleva l'eccezione per gestirla nel thread JavaFX
                            throw e;
                        } catch (IOException e) {
                            System.err.println("Errore durante l'importazione: " + e.getMessage());
                            throw e;
                        }
                        return null;
                    }
                };

                // Azioni al termine del task
                task.setOnSucceeded(e -> {
                    progressIndicator.setVisible(false);
                    aggiornaListe(event); // Aggiorna la lista al termine dell'importazione
                });

                task.setOnFailed(e -> {
                    progressIndicator.setVisible(false);

                    Throwable exception = task.getException();
                    if (exception instanceof InvalidContactException) {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        alertStage.getIcons().add(new Image(this.getClass().getResource("alerticon.png").toString()));
                        // Carica il file CSS
                        errorAlert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());
                        errorAlert.setTitle("Errore di validazione");
                        errorAlert.setHeaderText("Errore durante l'importazione della rubrica");
                        errorAlert.setContentText("Il file contiene dati non validi. Correggere e riprovare.");
                        errorAlert.setGraphic(null);
                        errorAlert.showAndWait();
                    } else {
                        System.err.println("Errore durante il processo di importazione.");
                    }
                });

                // Avvia il task su un thread separato
                new Thread(task).start();
            } else {
                System.out.println("Importazione annullata.");
            }
        }
    }

    /**
     * @brief esporta rubrica in un file CSV
     * 
     * Mostra una finestra per selezionare dove salvare il nuovo file
     * 
     * @param event 
     */
    @FXML
    private void esportaRubrica(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleziona la destinazione per esportare la rubrica");

        fileChooser.setInitialFileName("rubrica.csv");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("File CSV", "*.csv")
        );

        Window window = ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        File file = fileChooser.showSaveDialog(window);

        if (file != null) {
            try {
                if (!file.getName().endsWith(".csv")) {
                    file = new File(file.getAbsolutePath() + ".csv");
                }

                if (rubrica.esportaContatti(file)) {

                    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    Stage alertStage = (Stage) confirmAlert.getDialogPane().getScene().getWindow();
                    alertStage.getIcons().add(new Image(this.getClass().getResource("alerticon.png").toString()));

                    // Carica il file CSS
                    confirmAlert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());

                    confirmAlert.setTitle("EVVIVA!");
                    confirmAlert.setHeaderText("Rubrica esportata con successo in: " + file.getAbsolutePath());
                    confirmAlert.setGraphic(null);
                    confirmAlert.showAndWait();
                    System.out.println("Rubrica esportata con successo in: " + file.getAbsolutePath());
                } else {
                    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);

                    // Carica il file CSS
                    confirmAlert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());

                    confirmAlert.setTitle("E' stato riscontrato un problema!");
                    confirmAlert.setHeaderText("Esportazione fallita.");
                    confirmAlert.setGraphic(null);
                    confirmAlert.showAndWait();
                    System.out.println("Esportazione fallita.");
                }
            } catch (IOException e) {
                System.err.println("Errore durante l'esportazione: " + e.getMessage());
            }
        } else {
            System.out.println("Esportazione annullata.");
        }
    }

}
