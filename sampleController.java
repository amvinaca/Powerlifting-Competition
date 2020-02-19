package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.*;
import javafx.stage.Stage;

import java.io.IOException;


public class sampleController {

    public void login(ActionEvent Action) throws IOException {
        try {

            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root1 = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("TX PowerLifting");
            stage.show();
            ((Node) (Action.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("Could not open file.");
        }
    }


    }


