/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> contactTable;
    @FXML
    private TableColumn<?, ?> nameTable;
    @FXML
    private TableColumn<?, ?> lastNameTable;
    @FXML
    private TableView<?> altNameTable;
    @FXML
    private TableColumn<?, ?> altTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void switchToSceneDefault(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void switchToAddScene(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void switchToModifyScene(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @FXML
    public void switchToViewContactScene(ActionEvent event){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void aggiungiContatto(ActionEvent e) {
        
    }
    
    public void modificaContatto(ActionEvent e) {
        
    }
    
    public void eliminaContatto(ActionEvent e) {
        
    }
    
    public void importaContatti (ActionEvent e) {
    
    }
    
    public void esportaContatti (ActionEvent e) {
    
    }
    
    
    
}
