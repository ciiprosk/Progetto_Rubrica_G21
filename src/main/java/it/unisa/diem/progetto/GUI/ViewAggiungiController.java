/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class ViewAggiungiController implements Initializable {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField primoNumero;
    @FXML
    private TextField secondoNumero;
    @FXML
    private TextField terzoNumero;
    @FXML
    private TextField primaMail;
    @FXML
    private TextField secondaMail;
    @FXML
    private TextField terzaMail;
    @FXML
    private Button ritornaPulsante;
    @FXML
    private Button aggiungiPulsante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
