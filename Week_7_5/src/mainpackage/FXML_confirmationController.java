/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author m7942
 */
public class FXML_confirmationController implements Initializable {
    @FXML
    private Label quitLabel;
    @FXML
    private Button quitYesB;
    @FXML
    private Button quitNoB;
    @FXML
    public int suljetaan = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quitLabel.setWrapText(true);
        quitLabel.setText("Oletko varma että haluat sulkea ohjelman?");
        // TODO
    }

    @FXML
    private void quitYes(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void quitNo(ActionEvent event) {
        Stage stage = (Stage) quitNoB.getScene().getWindow();
        stage.close();
    }
    
    
    
}
