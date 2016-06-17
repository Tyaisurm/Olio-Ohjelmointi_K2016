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
    
    private static Stage pStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        setStage(stage);
        Scene scene = new Scene(root);
        pStage.setTitle("New Tab - Internet Crawler");
        pStage.setScene(scene);
        pStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getStage(){
        return pStage;
    }
    private void setStage(Stage pStage){
        Mainclass.pStage = pStage;
    } 
    
}
