/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.rubrica.Contatto;
import it.unisa.diem.progetto.rubrica.Rubrica;
import it.unisa.diem.progetto.validazioneContatti.EMailValidator;
import it.unisa.diem.progetto.validazioneContatti.NomeCognomeValidator;
import it.unisa.diem.progetto.validazioneContatti.NumTelefonoValidator;
import it.unisa.diem.progetto.validazioneContatti.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class ModificaController implements Initializable {
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
    
    private FXMLController fxmlController; //Riferimento al controller
    
    private Rubrica rubrica; // Riferimento alla rubrica
    
    private Contatto contatto; //Riferimento al contatto selezionato
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        salvaPulsante.setDisable(true);
    
    Validator telVal = new NumTelefonoValidator();
    Validator eMailVal = new EMailValidator();
    Validator nameVal = new NomeCognomeValidator();
    Validator surnameVal = new NomeCognomeValidator();
        
    
        //CONTROLLO NUMERI DI TELEFONO
        
        primoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        
        secondoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        
        terzoTelefonoField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        
        
        //CONTROLLO MAILS
        
        primaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
           controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        
        secondaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        
        terzaMailField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
        

        //CONTROLLO NOME E COGNOME
        nomeField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
            
        });
        
        cognomeField.textProperty().addListener((observable, oldValue, newValue) -> {
            controlloInput(telVal,eMailVal,nameVal,surnameVal);
        });
    } 
    
    //Metodo per controllare l'input dei campi telefono
    public void controlloInput(Validator telVal, Validator eMailVal, Validator nameVal, Validator surnameVal) {

        boolean primoTel = telVal.verifica(primoTelefonoField.getText());
        boolean secondoTel = telVal.verifica(secondoTelefonoField.getText());
        boolean terzoTel = telVal.verifica(terzoTelefonoField.getText());
        
        boolean primaMail = eMailVal.verifica(primaMailField.getText());
        boolean secondaMail = eMailVal.verifica(secondaMailField.getText());
        boolean terzaMail = eMailVal.verifica(terzaMailField.getText());
        
        boolean nome = nameVal.verifica(nomeField.getText());
        boolean cognome = surnameVal.verifica(cognomeField.getText());
        
        boolean nomeInserito = nameVal.inserito (nomeField.getText() );
        boolean cognomeInserito = surnameVal.inserito (cognomeField.getText() );
        
        
        salvaPulsante.setDisable( ! (nome && cognome) ||  !(nomeInserito || cognomeInserito) || ! (primoTel && secondoTel && terzoTel) 
        || ! (primaMail && secondaMail && terzaMail));
    }
    
    
    // Metodo per impostare il riferimento alla rubrica
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }


    // Metodo per impostare il controller principale
    public void setFXMLController(FXMLController fxmlController) {
        this.fxmlController = fxmlController;
    }
    
    public void setContatto(Contatto contatto){
        this.contatto = contatto;
        
        nomeField.setText(contatto.getNome());
        cognomeField.setText(contatto.getCognome());
        primoTelefonoField.setText(contatto.getNumTelefono1());
        secondoTelefonoField.setText(contatto.getNumTelefono2());
        terzoTelefonoField.setText(contatto.getNumTelefono3());
        primaMailField.setText(contatto.getEMail1());
        secondaMailField.setText(contatto.getEMail2());
        terzaMailField.setText(contatto.getEMail3());
    }

    @FXML
    private void switchToDefaultScene(ActionEvent event) {
        Stage stage = (Stage) annullaPulsante.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void modificaContatto(ActionEvent event) {
        System.out.println("Ancora da implementare");
    }
    
}
