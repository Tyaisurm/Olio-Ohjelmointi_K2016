/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author m7942
 */
public class Mainclass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        root.setStyle("-fx-background-image: url('" + getClass().getResource("Suomen-kartta.jpg").toExternalForm() + "');-fx-background-size: contain;-fx-background-repeat: stretch;-fx-background-position: center center");
        Scene scene = new Scene(root);
        stage.setMaxHeight(912);
        stage.setMaxWidth(728);
        stage.setMinHeight(912);
        stage.setMinWidth(728);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
