/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import bottleDispenser.Bottle;
import bottleDispenser.BottleDispenser;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button addMoneyButton;
    @FXML
    private Slider addMoneySlider;
    @FXML
    private Button returnMoneyButton;
    @FXML
    private ComboBox<String> chooseBottleButton;
    @FXML
    private Button buyButton;
    @FXML
    private ComboBox<Double> chooseSizeButton;
    @FXML
    private Label receiveBillLabel;
    private BottleDispenser pullonpalautin;
    private Bottle pullo = null;
    @FXML
    private Label printScreenLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.pullonpalautin = BottleDispenser.getInstance();
        String[] bottles = {"Pepsi Max", "Coca-Cola Zero", "Fanta Zero"};
        Double[] sizes = {0.5, 1.5};
        chooseBottleButton.getItems().addAll(bottles);
        chooseSizeButton.getItems().addAll(sizes);
    }

    @FXML
    private void addMoney(ActionEvent event) {
        System.out.println(pullonpalautin);
        System.out.println(addMoneySlider.getValue());
        if (addMoneySlider.getValue() != 0) {
            pullonpalautin.addMoney(addMoneySlider.getValue());
            receiveBillLabel.setText("KLINK! Rahea sataa taivaalta :D");
        } else {
            receiveBillLabel.setText("Aseta rahaa laitteeseen!");
        }
    }

    @FXML
    private void returnMoney(ActionEvent event) {
        Double raha = pullonpalautin.returnMoney();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("kuitti.txt"));
            bw.write("Kuitti:\n\n");
            if (pullo != null) {
                bw.write("Edellinen ostos: " + pullo.getName() + " " + pullo.getSize() + " " + pullo.getPrice() + "\n" + "Rahaa palautettu: " + (Math.round(raha*1000.0)/1000.0) + "\n");
            } else {
                bw.write("Rahaa palautettu: " + raha + "\n");
            }
            bw.write("Kiitos rahasta :^)");
            bw.close();
            receiveBillLabel.setText("Kuitti tulostettu!");
        } catch (FileNotFoundException ex) {
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            Scene scene = new Scene(new Group(new Text("Tiedostoa ei löytynyt.")));
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException ex) {
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            Scene scene = new Scene(new Group(new Text("IOException")));
            dialog.setScene(scene);
            dialog.show();
        }
    }

    @FXML
    private void buyBottle(ActionEvent event) throws InterruptedException {
        String nimi = chooseBottleButton.getSelectionModel().getSelectedItem();
        Double koko = chooseSizeButton.getSelectionModel().getSelectedItem();
        if (nimi != null && koko != null) {     
            Bottle temp = pullonpalautin.buyBottle(nimi, koko);
            if (temp != null) {
                receiveBillLabel.setText("KACHUNK! " + temp.getName() + " tipahti masiinasta!");
                pullo = temp;
            } else {
                receiveBillLabel.setText("Pulloa ei ole saatavilla tai rahaa liian vähän!");
            }                
        } else {
            receiveBillLabel.setText("Valitse pullo ja koko ensin!");
        }
    }

    @FXML
    private void listBottles(ActionEvent event) {
        String nimi = chooseBottleButton.getValue();
        Double koko = chooseSizeButton.getValue();
        if (nimi != null && koko != null) {
            printScreenLabel.setText(pullonpalautin.listBottles(nimi, koko));
        }
    }
}
