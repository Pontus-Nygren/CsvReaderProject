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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 *
 * @author QuagMir
 */
public class StartScreen implements Initializable {
    public static int loginId = 0;
//    private boolean SignLoad = false;
    @FXML 
    private Button signUpBtn;
    @FXML
    private Button signedUpBtn;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField pw;
    @FXML
    private PasswordField pwConfirm;
    @FXML
    private AnchorPane anchorpane;
     @FXML
    private AnchorPane anchorpane2;
    @FXML
    private TextField userField;
    @FXML 
    private PasswordField pwField;
    @FXML
    private ImageView imageview;
    @FXML
    private AnchorPane anka;
    @FXML
    private Label labelerr;
    @FXML
    private AnchorPane loginerr;
   @FXML
   private ImageView CancelView;
   @FXML
   private void exitFunc(){
   
       System.exit(0);
   
   
   }
   
   
   @FXML
   private void cancel(){
       Stage stg = (Stage) anka.getScene().getWindow();
       stg.close();
   }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       
        for(int i = 0; i<UserPageController.personList.size(); i++){
            if(UserPageController.personList.get(i).geteMail().equals(userField.getText()) && UserPageController.personList.get(i).getPassWord().equals(pwField.getText()) && UserPageController.personList.get(i).getRole().toLowerCase().equals("admin")){
                loginId = UserPageController.personList.get(i).getId();
                System.out.println("admin ID" + loginId);
                Parent pane = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
                 
                Scene scene2 = new Scene(pane);
                Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                //stg2.initStyle(StageStyle.TRANSPARENT);
                stg2.setScene(scene2);
                
                stg2.show();
                
            
            
            } else if(UserPageController.personList.get(i).geteMail().equals(userField.getText()) && UserPageController.personList.get(i).getPassWord().equals(pwField.getText()) && UserPageController.personList.get(i).getRole().toLowerCase().equals("courier")){
                loginId = UserPageController.personList.get(i).getId();
                System.out.println("courier ID" + loginId);
                Parent pane = FXMLLoader.load(getClass().getResource("userPage.fxml"));

                Scene scene2 = new Scene(pane);
                Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
               // stg2.initStyle(StageStyle.TRANSPARENT);
               
               stg2.setScene(scene2);
                
                stg2.show();
                

            }else if(!UserPageController.personList.get(i).geteMail().equals(userField.getText())){

                notification("Invalid input", 2);

            }else if(!UserPageController.personList.get(i).getPassWord().equals(pwField.getText())){
                notification("Invalid input", 2);
        
        
        }
        
      
        
        
    }
    }
    private void notification(String message, int type){
    if(type == 1){
    loginerr.setStyle("-fx-background-color: Green");
    }else if(type == 2){
     loginerr.setStyle("-fx-background-color: red");
    }
    labelerr.setText(message);
    FadeTransition notif = new FadeTransition(Duration.seconds(1),loginerr);
    notif.setFromValue(0);
    notif.setToValue(0.4);
    notif.setCycleCount(1);
    
    FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), loginerr);
    fadeOut.setFromValue(0.5);
    fadeOut.setToValue(0);
    fadeOut.setCycleCount(1);
    notif.play();
            
            
    notif.setOnFinished((e)->{
                fadeOut.play();
    });
    
    }
   
    @FXML
    private void signUp(ActionEvent event) throws IOException{
    Stage stage2;
    Parent root2;
    
    if(event.getSource()== signUpBtn){
//    SignLoad = true;
    stage2 = new Stage();
    root2 = FXMLLoader.load(getClass().getResource("signed.fxml"));
    stage2.setScene(new Scene(root2));
    stage2.initModality(Modality.APPLICATION_MODAL);
    stage2.initStyle(StageStyle.UNDECORATED);
    stage2.show();
    
    
    }else if(event.getSource() == signedUpBtn){
    if (pw.getText().equals(pwConfirm.getText()) && !pw.getText().isEmpty() && !fname.getText().isEmpty() && !lname.getText().isEmpty() && !mail.getText().isEmpty()){
    UserPageController.personList.add(new Person(CsvReader.id,fname.getText(), lname.getText(),mail.getText(), "Courier",pw.getText()));
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("User Added!");
    alert.setHeaderText("Sign up completed!");
    alert.setContentText("Welcome "+fname.getText()+"!");
    alert.initStyle(StageStyle.TRANSPARENT);
    alert.showAndWait();
    CsvReader.id ++;
    stage2 = (Stage)signedUpBtn.getScene().getWindow();
    stage2.close();
    
    
   
    }else{
        FadeTransition fade = new FadeTransition(Duration.seconds(2), anka);
            fade.setFromValue(0);
            fade.setToValue(0.5);
            fade.setCycleCount(1);
            
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), anka);
            fadeOut.setFromValue(0.5);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            fade.play();
            
            
            fade.setOnFinished((e)->{
                fadeOut.play();
            });
    }
//    SignLoad = false;
    
    
    }
    
    
    }
    
    private void loadWelcome(){
        try {
            CsvReader.isLoaded = true;
            StackPane pane = FXMLLoader.load(getClass().getResource("welcomeSplash.fxml"));
            
            anchorpane.getChildren().setAll(pane);
            
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            fadeIn.play();
            
            
            fadeIn.setOnFinished((e)->{
                fadeOut.play();
            });
            
             fadeOut.setOnFinished((e)->{
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource("StartScreenController.fxml"));
                    anchorpane.getChildren().setAll(parentContent);
                    
                } catch (IOException ex) {
                    Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
        } catch (IOException ex) {
            Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!CsvReader.isLoaded){
        loadWelcome();
        
        }
       
          
        
        
//        if (!SignLoad){
        File f1 = new File("src/img/close.png");
        Image img2 = new Image(f1.toURI().toString());
        
        imageview.setImage(img2);
//        anchorpane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.95);-fx-background-radius: 10 10 10 10; -fx-border-radius: 10 10 10 10;");
//        anchorpane2.setStyle("-fx-background-color: rgba(255, 0, 0, 0.2);-fx-background-radius: 10 0 0 10; -fx-border-radius: 10 0 0 10;");
//        
//        }

        
      

    }    
    
}
