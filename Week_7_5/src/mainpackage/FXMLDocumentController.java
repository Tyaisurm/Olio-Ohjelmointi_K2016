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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
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

    @FXML
    private void openFile(ActionEvent event) {
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
                    Stage dialog = new Stage();
                    dialog.initStyle(StageStyle.UTILITY);
                    Scene scene = new Scene(new Group(new Text("Tiedoston " + file.getName() + " lukeminen ei onnistunut")));
                    dialog.setScene(scene);
                    dialog.show();
                }
                //System.out.println(text);
                Tab tab = createTab(file.getName(), text);
                tabPanel.getSelectionModel().select(tab);

            } catch (FileNotFoundException ex) {
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoa " + file.getName() + " ei löytynyt")));
                dialog.setScene(scene);
                dialog.show();
            }
        }
    }

    @FXML
    private void saveFile(ActionEvent event) {
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
                    //EFAEKLNFÖJBFKÅNSÖFKNCF
                
                
                //
                
                
                OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                //byte[] inBytes = textArea.getText().getBytes();
                Tab tab = tabPanel.getSelectionModel().getSelectedItem();
                AnchorPane ap = (AnchorPane)tab.getContent();
                TextArea ta = (TextArea)ap.getChildren().get(0);
                //System.out.println(ta.getText());
                String cbuf = ta.getText();
                //for (int x = 0; x < textArea.getLength(); x++) {
                output.write(cbuf);
                //ouput.write(inBytes[x]);
                //System.out.println(cbuf);
                //}

                output.close();
                tab.setText(file.getName());

            } catch (FileNotFoundException ex) {
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoa " + file.getName() + " ei löytynyt.")));
                dialog.setScene(scene);
                dialog.show();
            } catch (IOException ex) {
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene scene = new Scene(new Group(new Text("Tiedostoon " + file.getName() + " kirjoittaminen ei onnistunut")));
                dialog.setScene(scene);
                dialog.show();
            }
        }
    }

    @FXML
    private void newFile(ActionEvent event) {
        Tab tab = createTab("Uusi Tiedosto", "");
        tabPanel.getSelectionModel().select(tab);
    }

    @FXML
    private void showAbout(ActionEvent event) {
        int response = JOptionPane.showConfirmDialog(null, "Tämä on vain opiskelijan tekemä, HYYYYYYVIN\npaska tekstieditori :D", "About", JOptionPane.PLAIN_MESSAGE);
    }

    private Tab createTab(String nimi, String teksti) {
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
