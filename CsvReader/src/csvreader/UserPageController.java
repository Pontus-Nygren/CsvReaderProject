/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.util.Duration;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * FXML Controller class
 *
 * @author QuagMir
 */
public class UserPageController implements Initializable {

    public static ArrayList<Person> personList = new ArrayList();
    public static ObservableList<Person> pList;
    private ObservableList<CsvClass> csvList;
    @FXML
    private AnchorPane notify;
    @FXML
    private ImageView imageview;
    @FXML
    private TableView<CsvClass> csvTable;
    @FXML
    private TableColumn<CsvClass, String> order;
    @FXML
    private TableColumn<CsvClass, String> date;
    @FXML
    private TableColumn<CsvClass, String> comment;
    @FXML
    private AnchorPane leftSplit;
    @FXML
    private AnchorPane rightSplit;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private SplitPane splitPane;
    @FXML
    private ImageView settingsView;
    @FXML
    private ImageView signOutView;
    @FXML
    private ImageView addView;
    @FXML
    private ImageView deleteview;

     Client client = ClientBuilder.newClient(); 
    
    
    @FXML
    private void exitFunc() {

        System.exit(0);
    }
    

    @FXML
    private void addFileBtn() throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\"));
        BufferedReader crunchifyBuffer = null;

        try {
            String fileLocation = null;

            System.out.println("empty filelocation");

            fileLocation = fc.showOpenDialog(null).getAbsolutePath();

            String crunchifyLine;

            crunchifyBuffer = new BufferedReader(new FileReader(fileLocation));

            
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                if (!crunchifyLine.isEmpty()) {
 
                    crunchifyCSVtoArrayList(crunchifyLine);
                }

            }
            for (int i = 0; i < personList.size(); i++) {

                if (personList.get(i).getId() == StartScreen.loginId) {
                    System.out.println("Addfile " + StartScreen.loginId + "GetID " + personList.get(i).getId());
                    csvList = FXCollections.observableArrayList(personList.get(i).getCsvList());
                    for (int j = 0; j < personList.get(i).getCsvList().size(); j++) {
                        System.out.println("CsvListobject " + personList.get(i).getCsvList().get(j));
                        order.setCellValueFactory(new PropertyValueFactory<>("orderNr"));
                        date.setCellValueFactory(new PropertyValueFactory<>("date"));
                        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
                    }

                }

            }
            csvTable.setItems(csvList);
            notification("File successfully added", 1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (crunchifyBuffer != null) {
                    crunchifyBuffer.close();
                }

            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }

    }

    @FXML
    public void handleEditAction(CellEditEvent<CsvClass, String> t) {
        ((CsvClass) t.getTableView().getItems().get(
                t.getTablePosition().getRow())).setComment(t.getNewValue());
        CsvClass csvtemp = t.getTableView().getSelectionModel().getSelectedItem();
        System.out.println("Newvalueordernr" + csvtemp.orderNr);
        Response r = client
                .target("http://localhost:8080/CsvBackendReader/webapi/person/csv/")
                .request()
                .put(Entity.entity(csvtemp, MediaType.APPLICATION_JSON));
        
        
        notification("Comment edited",1);
    }

    @FXML
    private void deleteFunction() {

        if (csvTable.getSelectionModel().getSelectedItem() == null) {
            System.out.println("Target for delete pls");
            notification("No file selected", 2);

        } else {
            String orderToDelete = csvTable.getSelectionModel().getSelectedItem().getOrderNr();
            Response r = client
                    .target("http://localhost:8080/CsvBackendReader/webapi/person/csv/" + orderToDelete)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();
            
//            for (int i = 0; i < personList.size(); i++) {
//                if (personList.get(i).getId() == StartScreen.loginId) {
//                    for (int k = 0; k < personList.get(i).getCsvList().size(); k++) {
//                        if (personList.get(i).getCsvList().get(k).getOrderNr().equals(orderToDelete)) {
//                            personList.get(i).getCsvList().remove(k);
//                            csvList = FXCollections.observableArrayList(personList.get(i).getCsvList());
//                            csvTable.setItems(null);
//                            csvTable.setItems(csvList);
//                        }
//
//                    }
//
//                }
//            }
List<CsvClass> personCsvList = client
               .target("http://localhost:8080/CsvBackendReader/webapi/person/csv/" + StartScreen.loginId)
               .request(MediaType.APPLICATION_JSON)
               .get(new GenericType<List<CsvClass>>() {});
        
        
        
        
          
                
                csvList = FXCollections.observableArrayList(personCsvList);
                System.out.println("CSVLISTSIZE" + csvList.size());
                for (int j=0; j<csvList.size();j++){
                    
                order.setCellValueFactory(new PropertyValueFactory<>("orderNr"));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));
                comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
                }
                csvTable.setItems(null);
                csvTable.setItems(csvList);
            notification("File succesfully deleted!", 1);
        }

    }
    @FXML
    private Label msgLabel;

    private void notification(String message, int type) {
        if (type == 1) {
            notify.setStyle("-fx-background-color: green");
        } else if (type == 2) {
            notify.setStyle("-fx-background-color:red");
        }

        msgLabel.setText(message);
        FadeTransition notif = new FadeTransition(Duration.seconds(1), notify);
        notif.setFromValue(0);
        notif.setToValue(0.4);
        notif.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), notify);
        fadeOut.setFromValue(0.5);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        notif.play();

        notif.setOnFinished((e) -> {
            fadeOut.play();
        });

    }

    @FXML
    private void logoutButton() throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("StartScreenController.fxml"));

        Scene scene2 = new Scene(login);
        Stage stg4 = (Stage) splitPane.getScene().getWindow();
        stg4.setTitle("");
        //stg4.initStyle(StageStyle.TRANSPARENT);
        stg4.setScene(scene2);
        stg4.show();
        StartScreen.loginId = 0;
        System.out.println("IDlogout" + StartScreen.loginId);
    }

    public void crunchifyCSVtoArrayList(String crunchifyCSV) {

        if (crunchifyCSV != null) {
            String[] splitData = crunchifyCSV.split("\\s*,\\s*");
            for (int q = 0; q < splitData.length; q++) {
                //  System.out.println("Col:"+q+"   " +splitData[q]);
            }
           
                
                    //System.out.println(personList.get(i).getFirstName());
                    CsvClass addCsv = new CsvClass(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], splitData[5]);
                    CsvClass csvClient = client 
                            .target("http://localhost:8080/CsvBackendReader/webapi/person/csv/" + StartScreen.loginId)
                            .request(MediaType.APPLICATION_JSON)
                            .post(Entity.json(addCsv), CsvClass.class);
                    
                    
                    //personList.get(i).getCsvList().add(new CsvClass(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], splitData[5]));


                
            

        }

        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<CsvClass> personCsvList = client
               .target("http://localhost:8080/CsvBackendReader/webapi/person/csv/" + StartScreen.loginId)
               .request(MediaType.APPLICATION_JSON)
               .get(new GenericType<List<CsvClass>>() {});
        
        
        
        
          
                
                csvList = FXCollections.observableArrayList(personCsvList);
                System.out.println("CSVLISTSIZE" + csvList.size());
                for (int j=0; j<csvList.size();j++){
                    
                order.setCellValueFactory(new PropertyValueFactory<>("orderNr"));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));
                comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
                
            

        }
        csvTable.setItems(csvList);

        File f1 = new File("src/img/close.png");
        Image img2 = new Image(f1.toURI().toString());
        imageview.setImage(img2);

        File f2 = new File("src/img/backarrow.png");
        Image img3 = new Image(f2.toURI().toString());
        signOutView.setImage(img3);

        File f3 = new File("src/img/Settings.png");
        Image img4 = new Image(f3.toURI().toString());
        settingsView.setImage(img4);

        comment.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
