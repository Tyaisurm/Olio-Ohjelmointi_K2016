/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private MenuItem menuOpen;
    @FXML
    private MenuItem menuSave;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private TabPane tabPanel;
    @FXML
    private String nimi = "Aloitus";
    @FXML
    private MenuItem menuNew;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createTab(nimi, "");
        // TODO
    }

    @FXML //Avataan haluttu tiedosto, joko .txt tai mikä tahansa
    private void openFile(ActionEvent event) {
        //luodaan tiedostonvalitsin
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Avaa tiedosto");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);

        if (file == null) {
            //
        } else {
            //kokeillaan lukemista
            try {
                InputStreamReader input = new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8").newDecoder());
                int c;
                String text = "";
                try {
                    while ((c = input.read()) != -1) {
                        text = text + (char) c;
                    }
                    input.close();
                } catch (IOException ex) {
                    //virhe-dialogi
                    Stage dialog = new Stage();
                    dialog.initStyle(StageStyle.UTILITY);
                    Scene scene = new Scene(new Group(new Text("Tiedoston " + file.getName() + " lukeminen ei onnistunut")));
                    dialog.setScene(scene);
                    dialog.show();
                }
                //luodaan uusi tab ja valitaan se. Sisältö luetaan sinne
                Tab tab = createTab(file.getName(), text);
                tabPanel.getSelectionModel().select(tab);

            } catch (FileNotFoundException ex) {
                //virhe-dialogi
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoa " + file.getName() + " ei löytynyt")));
                dialog.setScene(scene);
                dialog.show();
            }
        }
    }

    @FXML //tallennetaan valitun tabin sisältö haluttiuun tiedostoon
    private void saveFile(ActionEvent event) {
        //luodaan uusi tiedostonvalitsin
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Tallenna tiedosto");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        Stage stage = new Stage();
        File file = fileChooser.showSaveDialog(stage);

        if (file == null) {
            //
        } else {

            try {
                //kokeillaan kirjoittamista valittuun tiedostoon
                
                OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                
                //valitaan avoin tab ja otetaan sen sisältä TextArean sisältö muuttujaan
                Tab tab = tabPanel.getSelectionModel().getSelectedItem();
                AnchorPane ap = (AnchorPane)tab.getContent();
                TextArea ta = (TextArea)ap.getChildren().get(0);
                String cbuf = ta.getText();
                output.write(cbuf);

                output.close();
                tab.setText(file.getName());

            } catch (FileNotFoundException ex) {
                //virhe-dialogi
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoa " + file.getName() + " ei löytynyt.")));
                dialog.setScene(scene);
                dialog.show();
            } catch (IOException ex) {
                //virhe-dialogi
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoon " + file.getName() + " kirjoittaminen ei onnistunut")));
                dialog.setScene(scene);
                dialog.show();
            }
        }
    }

    @FXML //luodaan uusi tiedosto, eli avataan uusi tab joka on tyhjä sisällöltään
    private void newFile(ActionEvent event) {
        Tab tab = createTab("Uusi Tiedosto", "");
        tabPanel.getSelectionModel().select(tab);
    }

    @FXML //näytetään "About" info
    private void showAbout(ActionEvent event) {
        int response = JOptionPane.showConfirmDialog(null, "Tämä on vain opiskelijan tekemä, HYYYYYYVIN\npaska tekstieditori :D", "About", JOptionPane.PLAIN_MESSAGE);
    }

    private Tab createTab(String nimi, String teksti) {
        
        //tässä metodissa luodaan uusi tab, jolle asetetaan tekstisisältö ja nimi.
        //Palautetaan kyseinen tab, jotta voidaan vaivattomasti valita se avatessa.
        //Samalla tarkistetaan olemassa olevat tabit ja niiden ID:t
        Tab tab = new Tab();
        tab.setText(nimi);
        tab.setClosable(true);
        TextArea ta = new TextArea();
        ta.setText(teksti);
        ta.setPrefWidth(533.0);
        ta.setPrefHeight(407.0);
        AnchorPane ap = new AnchorPane();
        ap.getChildren().add(ta);
        ap.setLeftAnchor(ta, 0.0);
        ap.setBottomAnchor(ta, 0.0);
        ap.setTopAnchor(ta, 0.0);
        ap.setRightAnchor(ta, 0.0);
        tab.setContent(ap);
        String id = "";
        int i = 0;
        System.out.println(tabPanel.getTabs().size());
        if (tabPanel.getTabs().size() > 0) {
            for (Tab o : tabPanel.getTabs()) {
                id = ("Tab_" + i);
                if (!o.getId().equals(id)) {
                    break;
                } else {
                    //
                }
            }
        } else {
            id = "Tad_0";
        }
        tab.setId(id);
        tabPanel.getTabs().add(tab);
        return tab;
    }
}
