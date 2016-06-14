/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import parsing.*;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ComboBox<TheatreData> chooseMovieCombo;
    @FXML
    private TextField startingTimeField;
    @FXML
    private TextField airingDateField;
    @FXML
    private TextField endingTimeField;
    @FXML
    private Button listMoviesButton;
    @FXML
    private TextField nameSearchField;
    @FXML
    private Button nameSearchButton;
    @FXML
    private ListView<?> listView;
    @FXML
    private ProgressIndicator progressIndicatorIcon;//not visible
    @FXML
    private Label progressIndicatorLabel;//not visible
    @FXML
    private ParseXML parseXML; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.parseXML = ParseXML.getInstance();
        
        String code = parseXML.getCode("http://www.finnkino.fi/xml/TheatreAreas/");
        ArrayList<TheatreData> al = parseXML.getTheatresCombo(code, "TheatreArea", "ID", "Name");
        chooseMovieCombo.getItems().addAll(al);
        
        ///////////////////////
        System.out.println("Mäppi/ArrayList on: ");
        for(int a= 0;a<al.size();a++){
            System.out.println(al.get(a).getID()+ " ja " +al.get(a).getName());
        }
        //////////////////////
    }    

    @FXML
    private void searchByDate(ActionEvent event) {
        String startT = startingTimeField.getText();
        String endF = endingTimeField.getText();
        TheatreData theatre = chooseMovieCombo.getSelectionModel().getSelectedItem();
        int theatreID = theatre.getID();
    }

    @FXML
    private void searchByName(ActionEvent event) {
        String movieName = nameSearchField.getText();
    }
}
