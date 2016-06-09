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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button buttonInput;
    @FXML
    private Label label;
    @FXML
    private Button clearButton;
    @FXML
    private Slider sizeSlider;
    @FXML
    private TextField inputField;
    @FXML
    private CheckBox pickWorld;
    private boolean checked;
    @FXML
    private Label updatingLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Hello world!");
        if(checked == false){
        label.setText(inputField.getText());
        }
        if(checked == true){
            inputField.setText("HELLO WORLD");
        }
    }

    
    @FXML
    private void clearAction(ActionEvent event) {
        if(checked == false){
        label.setText(null);
        }
        inputField.clear();
    }

    @FXML
    private void sliderChange(MouseEvent event) {
        if(checked == false){
        System.out.println("Slideriä muutettu :d");
        label.setFont(new Font(sizeSlider.getValue()));
        }
    }

    @FXML
    private void yesWorld(ActionEvent event) {
        checked = pickWorld.selectedProperty().get();
        if(checked == true){
            label.setText("HELLO WORLD!!! :DDDDDD");
            updatingLabel.setText("HELLO WORLD");
        }
        else{
            label.setText("TEKSTIÄ");
        }
        }

    @FXML
    private void writingText(KeyEvent event) {
        System.out.println(":DDDDDDDD");
        updatingLabel.setText(inputField.getText());
    }

}
