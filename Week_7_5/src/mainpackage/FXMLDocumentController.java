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
import static java.nio.charset.StandardCharsets.UTF_8;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private MenuItem menuClose;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private Tab tab;
    @FXML
    private TextArea textArea;
    @FXML
    private TabPane tabPanel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        if(file == null){
            //
        }
        else{

        try {
            InputStreamReader input = new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8").newDecoder());
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
            textArea.setText(text);

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
        
        if(file == null){
            //
        }
        else{

        try {
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            //byte[] inBytes = textArea.getText().getBytes();
            String cbuf = textArea.getText();
            //for (int x = 0; x < textArea.getLength(); x++) {
                output.write(cbuf);
                //ouput.write(inBytes[x]);
                //System.out.println(cbuf);
            //}

            output.close();

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
    private void closeFile(ActionEvent event) {
    }

    @FXML
    private void showAbout(ActionEvent event) {
    }

}
