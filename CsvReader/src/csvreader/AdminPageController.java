/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author QuagMir
 */
public class AdminPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> first;
    @FXML
    private TableColumn<Person, String> last;
    @FXML
    private TableColumn<Person, Integer> id;

    @FXML
    private TableView<CsvClass> csvTable;
    @FXML
    private TableColumn<CsvClass, String> order;
    @FXML
    private TableColumn<CsvClass, String> date;
    @FXML
    private ImageView imageview;
    @FXML
    private AnchorPane leftSplit;
    @FXML
    private AnchorPane rightSplit;
    @FXML
    private AnchorPane tablePane;
    @FXML
    private ImageView settingsView;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView signOutView;
    @FXML
    private SplitPane splitPane;
    private ObservableList<CsvClass> csvList;
    private ObservableList<Person> searchList;

    private void LoadList() {

        for (int i = 0; i < UserPageController.pList.size(); i++) {
            System.out.println("test:" + UserPageController.pList.get(i).geteMail());
            first.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            last.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
        }
        personTable.setItems(null);
        personTable.setItems(UserPageController.pList);
    }

    @FXML
    private void exitFunc() {

        System.exit(0);
    }

    @FXML
    public void loadFromPerson() {

        if (personTable.getSelectionModel().getSelectedItem() == null) {
            System.out.println("wat");
        } else {

            System.out.println("hej");
            csvList = FXCollections.observableArrayList(personTable.getSelectionModel().getSelectedItem().getCsvList());
            for (int i = 0; i < personTable.getSelectionModel().getSelectedItem().getCsvList().size(); i++) {
                System.out.println(personTable.getSelectionModel().getSelectedItem().getCsvList().get(i).CLName);
                order.setCellValueFactory(new PropertyValueFactory<>("orderNr"));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));

            }
            csvTable.setItems(csvList);
        }
    }

    @FXML
    private void logoutButton() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("StartScreenController.fxml"));

        Scene scene2 = new Scene(login);
        Stage stg4 = (Stage) splitPane.getScene().getWindow();
        stg4.setTitle("");
        stg4.setScene(scene2);
        stg4.show();
        StartScreen.loginId = 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserPageController.pList = FXCollections.observableArrayList(UserPageController.personList);
        LoadList();

        File f1 = new File("src/img/close.png");
        Image img2 = new Image(f1.toURI().toString());
        imageview.setImage(img2);

        File f2 = new File("src/img/backarrow.png");
        Image img3 = new Image(f2.toURI().toString());
        signOutView.setImage(img3);

        File f3 = new File("src/img/Settings.png");
        Image img4 = new Image(f3.toURI().toString());
        settingsView.setImage(img4);

        searchField.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                searchList = FXCollections.observableArrayList();
                if (searchField.getText().equals(null)) {

                } else {

                    for (int i = 0; i < UserPageController.pList.size(); i++) {
                        if (UserPageController.pList.get(i).getFirstName().toLowerCase().contains(searchField.getText().toLowerCase())) {
                            searchList.add(UserPageController.pList.get(i));
                            first.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                            last.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                            id.setCellValueFactory(new PropertyValueFactory<>("id"));
                        }
                    }
                    personTable.setItems(null);
                    personTable.setItems(searchList);
                }
            }

        });

    }
}
