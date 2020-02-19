// Code reference: https://www.youtube.com/watch?v=uh5R7D_vFto

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    double weightplates;

    //configure the table
    @FXML
    private TableView<participants> tableView;
    @FXML
    private TableColumn<participants, String> firstNameColumn;
    @FXML
    private TableColumn<participants, String> bodyWeight;
    @FXML
    private TableColumn<participants, String> weightLifted;
    @FXML
    private TableColumn<participants, String> gender;
    @FXML
    private TableColumn<participants, String> type;
    @FXML
    private TableColumn<participants, String> goodBad;

    //these instance variable are used to create new participants objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField bodyWeightTextField;
    @FXML private TextField weightLiftedTextField;
    @FXML private TextField genderTextField;
    @FXML private TextField typeTextField;
    @FXML private TextField goodTextField;

    //these instance variable are used to output selected participant at the beginning
    @FXML private TextField screenName,screenGender,screenBody,screenWeight,screenType,screenGood;

    private ObservableList<participants> people;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        people = FXCollections.observableArrayList();

        people.add(new participants("Amy Marshall","20","62", "Female","Bench Press","Good"));
        people.add(new participants("Daniel Lala","25","60", "Male","Squat","Good"));
        people.add(new participants("Janet Noma","5","59", "Female","Deadlift","Bad"));
        people.add(new participants("Mary Smith","20","62", "Female","Bench Press","Good"));
        people.add(new participants("Logan Carter","25","60", "Male","Squat","Bad"));
        people.add(new participants("Alan Brady","5","207", "Male","Deadlift","Good"));

        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<participants, String>("firstName"));
        bodyWeight.setCellValueFactory(new PropertyValueFactory<participants, String>("bodyWeight"));
        weightLifted.setCellValueFactory(new PropertyValueFactory<participants, String>("weightLifted"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        goodBad.setCellValueFactory(new PropertyValueFactory<>("goodBad"));

        //load data
        tableView.setItems(people);
        //update table to allow edit
        tableView.setEditable(true);//double click an edit
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        bodyWeight.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        weightLifted.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        gender.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        type.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        goodBad.setCellFactory(TextFieldTableCell.forTableColumn());//double click an edit
        //this will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }




    public void changeFirstNameCell(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setFirstName(editedCell.getNewValue().toString());
    }

    public void changeWeightLifted(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setWeightLifted(editedCell.getNewValue().toString());
    }

    public void changeBodyWeight(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setBodyWeight(editedCell.getNewValue().toString());
    }

    public void changeGenderCell(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setGender(editedCell.getNewValue().toString());
    }

    public void changeTypeCell(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setType(editedCell.getNewValue().toString());
    }

    public void changeGoodCell(TableColumn.CellEditEvent editedCell)// double click an edit
    {
        participants PersonSelected=tableView.getSelectionModel().getSelectedItem();
        PersonSelected.setGoodBad(editedCell.getNewValue().toString());
    }


    //this method is to add participants
    public void newPersonButtonPushed()
    {
        participants newPerson= new participants(firstNameTextField.getText(),bodyWeightTextField.getText(),weightLiftedTextField.getText(),genderTextField.getText(),typeTextField.getText(),goodTextField.getText());
        tableView.getItems().add(newPerson);
    }


    //method to remove the selected row(s) from table
    public void deleteButtonPushed()
    {
        ObservableList<participants>selectedRows,allPeople;
        allPeople=tableView.getItems();

        //this gives us the rows that were selected
        selectedRows=tableView.getSelectionModel().getSelectedItems();
        selectedRows=tableView.getSelectionModel().getSelectedItems();

        for(participants person:selectedRows)
        {
            allPeople.remove(person);
        }

    }

    @FXML
    private void displaySelected(MouseEvent event)
    {
        participants person=tableView.getSelectionModel().getSelectedItem();
        if(person==null)
        {
            screenName.setText("");
            screenGender.setText("");
            screenBody.setText("");
            screenWeight.setText("");
            screenType.setText("");
            screenGood.setText("");
        }else
        {
            String name=person.getFirstName();
            String gender=person.getGender();
            String body=person.getBodyWeight();
            String weight=person.getWeightLifted();
            weightplates = Double.parseDouble(weight);
            String type=person.getType();
            String good=person.getGoodBad();
            screenName.setText(name);
            screenGender.setText(gender);
            screenBody.setText(body+" KG");
            screenWeight.setText(weight+" KG");
            screenType.setText(type);
            screenGood.setText(good);
        }
    }

    @FXML
    private void displayWeights(ActionEvent display) throws IOException {
        try {
            Stage stage = new Stage();
            stage.setTitle("Displayed Weight");

            StackPane root = new StackPane();

            Color[] colors = new Color[9];
            colors[0] = Color.BLUE;
            colors[1] = Color.GREEN;
            colors[2] = Color.YELLOW;
            colors[3] = Color.DARKRED;
            colors[4] = Color.BEIGE;
            colors[5] = Color.RED;
            colors[6] = Color.BLUEVIOLET;
            colors[7] = Color.CYAN;
            colors[8] = Color.CADETBLUE;

            HBox platesBox = new HBox();
            weightplates +=.01;
            weightplates -=20.01;
            weightplates/=2;
            int plates = 0;


            while(weightplates >= 50){
                weightplates -= 50;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(50 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(100);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[0]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }

            plates = 0;
            while(weightplates >= 25){
                weightplates -= 25;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(25 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(95);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[1]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= 15){
                weightplates -= 15;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(15 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(90);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[2]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= 10){
                weightplates -= 10;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(10 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(85);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[3]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= 5){
                weightplates -= 5;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(5 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(80);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[4]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= 2.50){
                weightplates -= 2.50;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(2.5 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(75);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[5]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= 1.25){
                weightplates -= 1.25;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(1.25 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(70);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[6]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= .50){
                weightplates -= .50;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(.50 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(65);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[7]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }
            plates = 0;
            while(weightplates >= .25){
                weightplates -= .25;
                plates++;
            }
            for (int i = 0; i < plates; i++){
                Text text = new Text(.25 +"kg");
                Rectangle plate = new Rectangle();
                plate.setWidth(40);
                plate.setHeight(60);
                plate.setStroke(Color.BLACK);
                plate.setFill(colors[8]);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(plate, text);
                platesBox.getChildren().add(stack);
            }

            root.getChildren().add(platesBox);
            Scene scene = new Scene(root, 400, 250);
            scene.getStylesheets().add("sample/styleSheet.css");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Could not open file.");
        }
    }



}
