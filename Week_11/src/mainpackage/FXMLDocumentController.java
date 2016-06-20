/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {

    ShapeHandler sh;
    @FXML
    private Button drawToggleButton;
    @FXML
    private Label toggleLabel;
    private boolean drawSpots = true;
    private String name = "piste";
    @FXML
    private AnchorPane lineAnchor;
    @FXML
    private AnchorPane spotAnchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sh = ShapeHandler.getInstance();
    }

    @FXML
    private void drawToggle(ActionEvent event) {
        if (drawSpots == true) {
            toggleLabel.setText("Line drawing enabled");
            drawToggleButton.setText("Toggle spot drawing");
            drawSpots = false;
        } else {
            toggleLabel.setText("Spot drawing enabled");
            drawToggleButton.setText("Toggle line drawing");
            drawSpots = true;
        }
    }

    @FXML
    private void baseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            //lisätään piste/viiva
            if (drawSpots == true) {
                System.out.println("piirretään piste");
                Point point = new Point();
                Circle circle = point.createNewCircle(name, event.getX(), event.getY());
                spotAnchor.getChildren().add(circle);
                sh.addPoint(point);

            } else {
                LineC lineC = new LineC();
                Line line = lineC.createNewLine(sh.getCircleS(), sh.getCircleE());
                boolean ok = true;

                if (line != null) {
                    ArrayList<LineC> testlist = sh.getLineList();
                    if (!testlist.isEmpty()) {
                        LineC testlineC = testlist.get(testlist.size() - 1);
                        Line testline = testlineC.getLine();
                        if ((testline.getStartX() == line.getStartX()) && testline.getStartY() == line.getStartY()) {
                            if ((testline.getEndX() == line.getEndX()) && testline.getEndY() == line.getEndY()) {
                                System.out.println("SAMAT LÄHTÖ XY JA LOPPU XY");
                                ok = false;
                            }
                        }
                    }
                    if (!sh.getCircleS().equals(sh.getCircleE())) {
                        if (ok) {
                            lineAnchor.getChildren().add(line);
                            sh.addLine(lineC);
                            System.out.println("LISÄTTIIN");
                        }
                    }
                    else{
                        System.out.println("SAMAT PALLOT!");
                    }
                }
                //System.out.println(line);
                //System.out.println(line.getStartX() + " ja " + line.getStartY());
                //System.out.println(line.getEndX() + " ja " + line.getEndY());
                //System.out.println("otetaan kaksi pistettä ja piirretään viiva");//
            }
        }
        /*if (event.getButton() == MouseButton.SECONDARY) {
         System.out.println("otetaan piste ja kerrotaan nimi");//kerrotaan nimi
            
         }*/
    }
}
