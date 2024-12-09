/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 *
 * @author anton
 */
public class InterfacciaController  implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField searchBar;
    @FXML
    private Button plusButton;
    @FXML
    private TableView<Contatto> contactTable;
    @FXML
    private TableColumn<Contatto, String> nameTable;
    @FXML
    private TableColumn<Contatto, String> lastNameTable;
    @FXML
    private TableView<Contatto> altNameTable;
    @FXML
    private TableColumn<Contatto, String> altTable;
    
     private ObservableList<Contatto> contatti;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contatti = FXCollections.observableArrayList();
        contactTable.setItems(contatti);
        
        nameTable.setCellValueFactory(new PropertyValueFactory("nome"));
        lastNameTable.setCellValueFactory(new PropertyValueFactory("cognome"));
    }
    
    @FXML
    public void switchToSceneDefault(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void apriAggiugngiScena(ActionEvent event) throws IOException{
            // Carica il layout del pop-up
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAggiungiController.fxml"));
            Parent aggiungiRoot = loader.load();

            // Crea e mostra il pop-up
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.WINDOW_MODAL); // Modalità bloccante
            popupStage.setScene(new Scene(aggiungiRoot));
            popupStage.showAndWait(); // Attende la chiusura del pop-up
        
    }
    
    @FXML
    public void switchToModifyScene(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void switchToViewContactScene(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void aggiungiContatto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void modificaContatto(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void eliminaContatto(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importaContatti (ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void esportaContatti (ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
