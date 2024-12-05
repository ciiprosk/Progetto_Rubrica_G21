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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void aggiungiContatto(Contatto c) {
        
    }
    
    public void modificaContatto(Contatto c) {
        
    }
    
    public void eliminaContatto(Contatto c) {
        
    }
    
    public void importaContatto (Contatto c) {
    
    }
    
    public void esportaContatto (Contatto c) {
    
    }
    
    
    
}
