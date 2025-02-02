
package it.unisa.diem.progetto.GUI;

import it.unisa.diem.progetto.rubrica.Rubrica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *  Main class
 */
public class InterfacciaMain extends Application {

    /**
     * @brief  * Carica l'interfaccia grafica dalla risorsa FXML, imposta il titolo e l'icona della finestra
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        stage.setTitle("Rubrica");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));

        stage.setOnCloseRequest(event -> {
            Rubrica.chiudiRubrica();
            System.out.println("Connessione chiusa");
        });
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief metodo principale che avvia l'applicazione JavaFX.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

}
