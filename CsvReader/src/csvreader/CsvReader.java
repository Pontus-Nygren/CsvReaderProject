/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author QuagMir
 */
public class CsvReader extends Application {
    public static int id=4;
    public static boolean isLoaded = false;
    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet
(getClass().getResource("Css.css").toExternalForm());
        Parent root = FXMLLoader.load(getClass().getResource("StartScreenController.fxml"));
        
        Scene scene = new Scene(root);
        scene.setFill(null);
//        scene.getStylesheets().add(StartScreen.class.getResource("Css.css").toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserPageController.personList.add(new Person(1,"Karl", "Johansson","Karl@csvmail.se", "Courier","Guacamole"));
        UserPageController.personList.add(new Person(2,"Karl2", "Johansson","Karl2@csvmail.se", "Admin","Guacamole2"));
        UserPageController.personList.add(new Person(3,"Dara","MacCarter","dmaccarter2@people.com.cn","Courier","JqBLA3P0w"));
        UserPageController.personList.add(new Person(4,"Bastien","Ferron","bferron3@goo.ne.jp","Courier","NtOmccu"));
        UserPageController.personList.add(new Person(5,"Gale","Saenz","gsaenz4@earthlink.net","Courier","8rgRyNUVXtt"));
        UserPageController.personList.add(new Person(6,"Rockie","Sogg","rsogg5@google.com.hk","Courier","1mPlDzoJ"));
        UserPageController.personList.add(new Person(7,"Damaris","Sibray","dsibray6@nymag.com","Courier","vD6i4f2"));
        UserPageController.personList.add(new Person(8,"Gill","Hache","ghache7@wired.com","Courier","YhoYhIKd"));
        UserPageController.personList.add(new Person(9,"Keene","Leisman","kleisman8@wufoo.com","Courier","OQQ4fgKu"));
        UserPageController.personList.add(new Person(10,"Kahaleel","Sailer","ksailer9@sfgate.com","Courier","KFjWxw5HnzKS"));
        UserPageController.personList.add(new Person(11,"Wilton","Tilney","wtilney1@vinaora.com","Courier","1U8cTVjH"));
        UserPageController.personList.add(new Person(12,"Carly","Bastie","cbastie0@vinaora.com","Courier","cvRdEf4fp"));
        
        for(int i = 0; i<UserPageController.personList.size();i++){
            if(UserPageController.personList.get(i).getFirstName().equals("Karl")){
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("dd","dda","dda","dad","dad","Hej"));
            }
        }
        for(int i = 0; i<UserPageController.personList.size();i++){
            if(UserPageController.personList.get(i).getFirstName().equals("Dara")){
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("11/19/2016","4740232774","Cinéma","O'Hagerty","23580 Hermina Place","Heathcote and Sons"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("2/19/2017","6832233507","Aurélie","Mecchi","9577 Bartillon Terrace","Rogahn-Runolfsdottir"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("8/1/2016","5112527749","Alizée","Waycot","06 Mcbride Terrace","Ledner Inc"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("1/22/2017","3011798311","Béatrice","Lownds","0 Becker Terrace","Halvorson, Wyman and Christiansen"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("3/14/2017","9885515879","Tán","Kingsnode","85 Jackson Hill","Torphy, Goldner and Kuhlman"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("6/1/2016","4545915892","Ruò","Snowman","1965 Graceland Alley","Becker-Emard"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("3/13/2017","6025641676","Lài","Bedell","49 Sugar Drive","Jast Inc"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("7/28/2016","7954688933","Véronique","Shovel","83045 Bayside Court","Lynch, Nienow and Murphy"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/31/2016","3555207520","Miléna","Sandham","43985 Sycamore Park","Jacobson LLC"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("9/15/2016","9604169564","Félicie","Portsmouth","53 Warner Terrace","Prohaska and Sons"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("1/2/2017","4074318148","Clélia","Liddle","191 Mitchell Park","Kovacek, Wisoky and Murphy"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("4/29/2017","9732391251","Réjane","Heaslip","82373 Hudson Pass","Trantow-Haag"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/23/2016","7569846516","Kallisté","Fransson","87263 Meadow Vale Terrace","MacGyver-Homenick"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("2/19/2017","3785444982","Bérangère","Haggis","3154 Fremont Crossing","Bartoletti, Rohan and Ankunding"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/2/2016","6558512696","Crééz","Adamovitch","1293 Forest Run Court","Schimmel, Bayer and Volkman"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("7/12/2016","9246414012","Anaïs","Carslaw","570 Golf View Drive","Parisian-Thiel"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/14/2016","7943579879","Léonore","Atty","93 Huxley Parkway","Zulauf and Sons"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("5/16/2016","3967669467","Mélissandre","Yegorovnin","4464 Mockingbird Circle","Frami Inc"));
            }
        }
         for(int i = 0; i<UserPageController.personList.size();i++){
            if(UserPageController.personList.get(i).getFirstName().equals("Bastien")){           
          
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/23/2016","7569846516","Kallisté","Fransson","87263 Meadow Vale Terrace","MacGyver-Homenick"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("2/19/2017","3785444982","Bérangère","Haggis","3154 Fremont Crossing","Bartoletti, Rohan and Ankunding"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/2/2016","6558512696","Crééz","Adamovitch","1293 Forest Run Court","Schimmel, Bayer and Volkman"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("7/12/2016","9246414012","Anaïs","Carslaw","570 Golf View Drive","Parisian-Thiel"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("6/1/2016","4545915892","Ruò","Snowman","1965 Graceland Alley","Becker-Emard"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("3/13/2017","6025641676","Lài","Bedell","49 Sugar Drive","Jast Inc"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("2/19/2017","6832233507","Aurélie","Mecchi","9577 Bartillon Terrace","Rogahn-Runolfsdottir"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("8/1/2016","5112527749","Alizée","Waycot","06 Mcbride Terrace","Ledner Inc"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("7/28/2016","7954688933","Véronique","Shovel","83045 Bayside Court","Lynch, Nienow and Murphy"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/31/2016","3555207520","Miléna","Sandham","43985 Sycamore Park","Jacobson LLC"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("9/15/2016","9604169564","Félicie","Portsmouth","53 Warner Terrace","Prohaska and Sons"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("1/2/2017","4074318148","Clélia","Liddle","191 Mitchell Park","Kovacek, Wisoky and Murphy"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("4/29/2017","9732391251","Réjane","Heaslip","82373 Hudson Pass","Trantow-Haag"));
            
             UserPageController.personList.get(i).getCsvList().add(new CsvClass("1/22/2017","3011798311","Béatrice","Lownds","0 Becker Terrace","Halvorson, Wyman and Christiansen"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("3/14/2017","9885515879","Tán","Kingsnode","85 Jackson Hill","Torphy, Goldner and Kuhlman"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("10/14/2016","7943579879","Léonore","Atty","93 Huxley Parkway","Zulauf and Sons"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("5/16/2016","3967669467","Mélissandre","Yegorovnin","4464 Mockingbird Circle","Frami Inc"));
            UserPageController.personList.get(i).getCsvList().add(new CsvClass("11/19/2016","4740232774","Cinéma","O'Hagerty","23580 Hermina Place","Heathcote and Sons"));
            }
        }
        
        launch(args);
        
    }
    
}
