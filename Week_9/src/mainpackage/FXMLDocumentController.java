/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
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
    private ListView<String> listView;
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

        //parseXML.testi("http://www.finnkino.fi/xml/TheatreAreas/");
        ///////////////////////
        System.out.println("Mäppi/ArrayList on: ");
        for (TheatreData al1 : al) {
            System.out.println(al1.getID() + " ja " + al1.getName());
        }
    }

    @FXML
    private void searchByDate(ActionEvent event) {
        listView.getItems().clear();
        int mode = 0;
        Map<String, ArrayList<ShowData>> map = new TreeMap<>();
        SimpleDateFormat sdfIN = new SimpleDateFormat("dd.MM.yyyy");
        //DateFormat dfIN = sdfIN;
        String startT = startingTimeField.getText().trim();
        String endT = endingTimeField.getText().trim();
        String air = airingDateField.getText().trim();
        String movieName = null;

        /*if (air.isEmpty()) {
            Date dateDefault = new Date();
            air = sdfIN.format(dateDefault);
            airingDateField.setText(air);
        }*/

        try {
            sdfIN.setLenient(false);
            Date airD = sdfIN.parse(air);

            if (startT.isEmpty() || endT.isEmpty()) {
                if (!startT.isEmpty() && !endT.isEmpty()) {
                    SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
                    Date dateTime = sdfTime.parse(startT);
                    Date dateTime2 = sdfTime.parse(endT);
                } else if (startT.isEmpty() && endT.isEmpty()) {
                    //
                } else {
                    throw new TestException();
                }
            }

            TheatreData theatre = chooseMovieCombo.getSelectionModel().getSelectedItem();
            if (theatre == null) {
                JOptionPane.showConfirmDialog(null, "Valitse teatteri ensin!", "Virhe!", JOptionPane.PLAIN_MESSAGE);
                //System.out.println("Valitse teatteri ensin!");
            } else {
                int theatreID = theatre.getID();
                map = parseXML.getMoviesByDate(theatreID, startT, endT, air, movieName, mode);
            }
        } catch (ParseException | TestException ex) {
            JOptionPane.showConfirmDialog(null, "Virheellinen kenttä! Tarkista syöte.\nVinkki: aika on muotoa hh:mm ja päivämäärä muotoa dd.mm.yyyy.", "Virhe!", JOptionPane.PLAIN_MESSAGE);
            //System.out.println("Virheellinen kenttä!");
        }

        this.printList(map);
    }

    @FXML
    private void searchByName(ActionEvent event) {
        listView.getItems().clear();
        Map<String, ArrayList<ShowData>> map = new TreeMap<>();
        int mode = 1;
        String startT = null;
        String endT = null;
        String air = null;
        String movieName = nameSearchField.getText().trim().toLowerCase();
        int theatreID = -1;

        map = parseXML.getMoviesByName(theatreID, startT, endT, air, movieName, mode);
        this.printList(map);

    }

    @FXML
    private void printList(Map<String, ArrayList<ShowData>> map) {
        if (map.isEmpty()) {
            //System.out.println("Map(elokuvat) on tyhjä!");
        } else {
            SimpleDateFormat sdfD = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
            for (Map.Entry pair : map.entrySet()) {
                String nimi = (String) pair.getKey();
                ArrayList<ShowData> arrayL = (ArrayList) pair.getValue();
                listView.getItems().add(nimi + ":");
                for (ShowData data : arrayL) {
                    String place = data.getTheAndAud();
                    Date dateD = data.getShowStart();
                    String date = sdfD.format(dateD);
                    String showD = place + "   \t" + date;
                    listView.getItems().add("\t" + showD);
                }
            }
        }
    }

    @FXML
    private void loading(ActionEvent event) {
        //
        progressIndicatorLabel.setVisible(true);
        progressIndicatorIcon.setVisible(true);
        //
    }

    public class TestException extends Exception {

        public TestException() {
            super();
        }

        public TestException(String message) {
            super(message);
        }

        public TestException(String message, Throwable cause) {
            super(message, cause);
        }

        public TestException(Throwable cause) {
            super(cause);
        }
    }
}
