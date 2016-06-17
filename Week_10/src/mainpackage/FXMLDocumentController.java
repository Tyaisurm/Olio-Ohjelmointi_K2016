/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.net.URL;
import java.util.EventListener;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author m7942
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox vBOX;
    //@FXML
    //Stage stage = (Stage) vBOX.getScene().getWindow();
    @FXML
    private MenuItem savePageButton;
    @FXML
    private MenuItem newTabButton;
    @FXML
    private Button backPageButton;
    @FXML
    private Button nextPageButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TextField searchBar;
    @FXML
    private TabPane tabPane;
    @FXML
    private MenuItem clearHistory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.createTab(null, "");
        tabPane.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                        System.out.println("TESTI!!!!!!!!!!!!!!111");
                        //Tab selected = tabPane.getSelectionModel().getSelectedItem();
                        if (t1 != null) {
                            AnchorPane ap = (AnchorPane) t1.getContent();
                            WebView wv = (WebView) ap.getChildren().get(0);
                            int index = wv.getEngine().getHistory().getCurrentIndex();
                            ObservableList<Entry> entries = wv.getEngine().getHistory().getEntries();
                            try {
                                if (entries.get(index + 1) == null) {
                                    nextPageButton.setDisable(true);
                                } else {
                                    nextPageButton.setDisable(false);
                                }
                                if (entries.get(index - 1) == null) {
                                    backPageButton.setDisable(true);
                                } else {
                                    backPageButton.setDisable(false);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                                System.out.println("NAPATTU!");
                            }
                        }
                    }
                }
        );
        //nextPageButton.setDisable(false);
        //backPageButton.setDisable(false);

    }

    @FXML
    private void savePage(ActionEvent event) {
        Tab selected = tabPane.getSelectionModel().getSelectedItem();
        if (!(selected == null)) {
            AnchorPane ap = (AnchorPane) selected.getContent();
            WebView wv = (WebView) ap.getChildren().get(0);
            Document doc = wv.getEngine().getDocument();
            System.out.println("Tämä ei ole vielä valmis!");
        } else {
            JOptionPane.showConfirmDialog(null, "No page to be saved!", "Warning", JOptionPane.PLAIN_MESSAGE);
        }

    }

    @FXML
    private void openTab() {
        Tab tab = this.createTab(null, "");
        tabPane.getSelectionModel().select(tab);
        searchBar.requestFocus();
    }

    private Tab createTab(String nimi, String url) {
        if (nimi == null) {
            nimi = "New Tab";
        }
        url = this.parseURL(url);
        final Tab tab = new Tab();
        tab.setClosable(true);
        final WebView wv = new WebView();

        //menuasiaa \/
        /*final ContextMenu menu = new ContextMenu();
         menu.getItems().add(newTabButton);
         wv.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent mouse) {
         if (mouse.getButton() == MouseButton.SECONDARY) {
         menu.hide();
         menu.show(wv, mouse.getScreenX(), mouse.getScreenY());
         } else {
         menu.hide();
         }
         }
         });*/
        wv.setContextMenuEnabled(true);//default menu disabled

        AnchorPane ap = new AnchorPane();
        /*String tabTitle = wv.getEngine().getTitle();
         if (!(tabTitle == null)) {
         tab.setText(tabTitle);
         }*/

        wv.getEngine().getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            String title = wv.getEngine().getTitle();
                            if (title == null) {
                                searchBar.setText(wv.getEngine().getLocation());
                                tab.setText("New Tab");
                            } else {
                                searchBar.setText(wv.getEngine().getLocation());

                                tab.setText(title);
                            }
                        }
                    }
                }
        );
        wv.getEngine().load(url);
        //System.out.println("testataan enginetitleä! " + wv.getEngine().getTitle());

        ap.getChildren().add(wv);
        ap.setLeftAnchor(wv, 0.0);
        ap.setBottomAnchor(wv, 0.0);
        ap.setTopAnchor(wv, 0.0);
        ap.setRightAnchor(wv, 0.0);
        tab.setContent(ap);
        tab.setText(nimi);
        //ObservableList<Entry> history = wv.getEngine().getHistory().getEntries();
        //ListIterator<Entry> iterator = history.listIterator();
        //tab.setUserData(iterator);
        tabPane.getTabs().add(tab);
        return tab;
    }

    @FXML
    private void backPage(ActionEvent event) {
        nextPageButton.setDisable(false);
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        AnchorPane ap = (AnchorPane) tab.getContent();
        WebView wv = (WebView) ap.getChildren().get(0);

        int index = wv.getEngine().getHistory().getCurrentIndex();
        ObservableList<Entry> entries = wv.getEngine().getHistory().getEntries();
        if ((index - 1) >= 0) {
            wv.getEngine().getHistory().go(-1);
        } else {
            System.out.println("EI VOIDA SIIRTYÄ(BACK)!" + (index - 1) + " " + entries.size());
        }
        if ((index - 2) >= 0) {
            System.out.println("VIELÄ ON SIVUJA JÄLJELLÄ(BACK)" + (index - 2) + " " + entries.size());
        } else {
            backPageButton.setDisable(true);
        }

        /*ListIterator listIterator = (ListIterator) tab.getUserData();
         if(listIterator.hasPrevious()){
         System.out.println(listIterator.previous());
         }
         for(WebHistory.Entry e : wv.getEngine().getHistory().getEntries()){
         System.out.println(e.getUrl());
         }*/
    }

    @FXML
    private void nextPage(ActionEvent event) {
        backPageButton.setDisable(false);
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        AnchorPane ap = (AnchorPane) tab.getContent();
        WebView wv = (WebView) ap.getChildren().get(0);

        int index = wv.getEngine().getHistory().getCurrentIndex();
        ObservableList<Entry> entries = wv.getEngine().getHistory().getEntries();
        if (entries.size() >= (index + 1 + 1)) {
            wv.getEngine().getHistory().go(1);
        } else {
            System.out.println("EI VOIDA SIIRTYÄ!(NEXT)" + (index + 1 + 1) + " " + entries.size());
        }
        if (entries.size() >= (index + 1 + 2)) {
            System.out.println("VIELÄ ON SIVUJA JÄLJELLÄ(NEXT)" + (index + 1 + 2) + " " + entries.size());
        } else {
            nextPageButton.setDisable(true);
        }
        /*ListIterator listIterator = (ListIterator) tab.getUserData();
         if(listIterator.hasNext()){
         System.out.println(listIterator.next());
         }
         for(WebHistory.Entry e : wv.getEngine().getHistory().getEntries()){
         System.out.println(e.getUrl());
         }*/
    }

    @FXML
    private void refreshPage(ActionEvent event) {

        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        AnchorPane ap = (AnchorPane) tab.getContent();
        WebView wv = (WebView) ap.getChildren().get(0);

        //wv.getEngine().executeScript("document.shoutOut()");
        wv.getEngine().reload();
        //System.out.println("TOIMIII");
    }

    private String parseURL(String urlIN) {//katsotaan onko alkuosat osoitteesta
        String url = urlIN.trim();
        if (url.contains("LOAD#")) {
            url = url.replaceFirst("LOAD#", "");
        } else if (!url.contains("www.")) {
            //url = "www.".concat(url);
            if (!url.contains("https://")) {
                //
                if (!url.contains("http://")) {
                    url = "http://".concat(url);
                }
            }
        }
        return url;
    }

    @FXML
    private void searchWebsite(ActionEvent event) {
        backPageButton.setDisable(false);
        nextPageButton.setDisable(true);
        String url = this.parseURL(searchBar.getText());
        if (tabPane.getTabs().size() == 0) {
            this.createTab(null, url);
        } else {
            Tab tab = tabPane.getSelectionModel().getSelectedItem();
            AnchorPane ap = (AnchorPane) tab.getContent();
            final WebView wv = (WebView) ap.getChildren().get(0);
            if (url.contains("http")) {
                wv.getEngine().load(url);
                this.searchBar.setText(url);

                //System.out.println(tabPane.getParent());
            } else {
                wv.getEngine().load(getClass().getResource(url).toExternalForm());
                this.searchBar.setText(url);
            }
            wv.getEngine().getLoadWorker().stateProperty().addListener(
                    new ChangeListener<State>() {
                        @Override
                        public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
                            if (newState == State.SUCCEEDED) {
                                searchBar.setText(wv.getEngine().getLocation());
                                Tab tab = tabPane.getSelectionModel().getSelectedItem();
                                AnchorPane ap = (AnchorPane) tab.getContent();
                                WebView wv = (WebView) ap.getChildren().get(0);
                                String title = wv.getEngine().getTitle();
                                if (title == null) {
                                    tab.setText("-No Title-");
                                } else {
                                    tab.setText(title);
                                }
                            }
                        }
                    }
            );
        }
    }

    @FXML
    private void clearHistory(ActionEvent event) {
        tabPane.getTabs().clear();
        System.out.println("kaikki tyhjennetty!");
    }
}
