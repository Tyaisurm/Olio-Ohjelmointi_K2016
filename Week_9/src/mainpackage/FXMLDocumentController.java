/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.net.URL;
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

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ComboBox<?> chooseMovieCombo;
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
    private Label prograssIndicatorLabel;
    @FXML
    private ProgressIndicator progressIndicatorIcon;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchByDate(ActionEvent event) {
    }

    @FXML
    private void searchByName(ActionEvent event) {
    }
    
}
