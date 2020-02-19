//Final Project
//Muneer Yuesef 1621986
//Amalia Vina 1840501

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class Main extends Application {


   @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TX PowerLifting");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



    @FXML
    public static void main(String[] args) {
        Application.launch(args);
    }
}
