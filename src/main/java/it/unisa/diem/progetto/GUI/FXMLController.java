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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
         private ObservableList<Contatto> contatti;
         
         private Rubrica rubrica;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica(new Database());
        contatti = FXCollections.observableArrayList(rubrica.visualizzaListaContattiCognome());
        contattiTabella.setItems(contatti);
        
        nomeColonna.setCellValueFactory(new PropertyValueFactory("nome"));
        cognomeColonna.setCellValueFactory(new PropertyValueFactory("cognome"));
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
    
    
    
}
