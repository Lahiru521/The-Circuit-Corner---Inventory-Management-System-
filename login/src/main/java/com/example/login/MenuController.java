package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MenuController {

    private Stage stage;

    private Scene scene;
    private Parent root;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane menuPane;

    public void switchtoMenu(ActionEvent event) throws IOException {
        //Load the main menu view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addItems(ActionEvent event) throws IOException {
        //Load the AddItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("AddItems.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteItems(ActionEvent event) throws IOException {
        //Load the DeleteItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("DeleteItems.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Delete Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updateItems(ActionEvent event) throws IOException {
        //Load the updateItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("UpdateItems.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Update Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewItems(ActionEvent event) throws IOException {
        //Load the viewItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("viewItems.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("view Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void selectFourDealers(ActionEvent event) throws IOException {
        //Load the selectFourDealers view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("selectFourDealers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Select Dealers");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void saveItems(ActionEvent event) throws IOException{
        //Load the saveItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("saveItems.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Save Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayDealerItemDetails(ActionEvent event) throws IOException {
        //Load the displayDealerItemDetails view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("DealerItems.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dealer Items");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void viewDealerItems(ActionEvent event) throws IOException{
        //Load the viewDealerItems view and switch to it
        Parent root = FXMLLoader.load(getClass().getResource("viewDealerItemDetails.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("View Items of All Dealers");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void exitProgram(ActionEvent event){
        //Display an alert to confirm exit and close the program
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You're About to Exit The Program!!!");
        alert.setContentText("Are You Sure??");
        if (alert.showAndWait().get()== ButtonType.OK){
            stage=(Stage)menuPane.getScene().getWindow();
            System.out.println("You Successfully Exit From The Program");
            stage.close();
        }


    }


}
