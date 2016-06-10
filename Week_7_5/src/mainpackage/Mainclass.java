/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author m7942
 */
public class Mainclass extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("A Very Shitty Text Editor xD");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event){
                event.consume();
                
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("FXML_confirmation.fxml"));
                    Scene sceneS = new Scene(root);
                    Stage stageD = new Stage();
                    stageD.setScene(sceneS);
                    stageD.setTitle("A Very Shitty Text Editor xD");
                    stageD.show();
                } catch (IOException ex) {
                    //
                }
            }
        });
            }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
