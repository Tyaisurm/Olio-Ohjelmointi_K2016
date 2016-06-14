/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author m7942
 */
public class Mainclass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setTitle("Finnkino-elokuvahaku :D");
        Scene scene = new Scene(root);
        
        
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.setMaxHeight(624);
        stage.setMaxWidth(485);
        stage.setMinHeight(624);
        stage.setMinWidth(485);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
