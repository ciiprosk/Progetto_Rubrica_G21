 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.rubrica.Contatto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contatti = FXCollections.observableArrayList();
        contattiTabella.setItems(contatti);
        
        nomeColonna.setCellValueFactory(new PropertyValueFactory("nome"));
    }    
    
}
