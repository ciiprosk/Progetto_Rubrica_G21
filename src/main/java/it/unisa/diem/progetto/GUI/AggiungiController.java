/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.validazioneContatti.EMailValidator;
import it.unisa.diem.progetto.validazioneContatti.NumTelefonoValidator;
import it.unisa.diem.progetto.validazioneContatti.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class AggiungiController implements Initializable {
    
    @FXML
    private TextField nomeField;
    
    @FXML
    private TextField cognomeField;

    @FXML
    private TextField primoTelefonoField;
    
    @FXML
    private TextField secondoTelefonoField;
    
    @FXML
    private TextField terzoTelefonoField;

    @FXML
    private TextField primaMailField;
    
    @FXML
    private TextField secondaMailField;

    @FXML
    private TextField terzaMailField;

    @FXML
    private Button salvaPulsante;
    
    @FXML
    private Button annullaPulsante;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        salvaPulsante.setDisable(true);
    
    Validator telVal = new NumTelefonoValidator();
    Validator eMailVal = new EMailValidator();
        
        primoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (telVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        secondoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (telVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        terzoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (telVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        //CONTROLLO MAILS
        
        primaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (eMailVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        secondaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (eMailVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        terzaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (eMailVal.verifica(newValue))
                salvaPulsante.setDisable(false);
            else salvaPulsante.setDisable(true);
        });
        
        
    }    




    @FXML
    private void aggiungiContatto(ActionEvent event) {
         
    }

    @FXML
    private void switchToDefaultScene(ActionEvent event) {
    }
    
}
