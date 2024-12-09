/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.gestioneContatti.Database;
import it.unisa.diem.progetto.gestioneContatti.DatabaseManager;
import it.unisa.diem.progetto.rubrica.Rubrica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author anton
 */
public class InterfacciaMain extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DA MODIFICARE
        launch(args);
    //apro anche la connessione quando chiamo il coatruttore
        //Rubrica rubrica=new Rubrica(new Database());
    }
    
}
