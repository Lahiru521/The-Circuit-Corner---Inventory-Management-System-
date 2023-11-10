package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;



import java.io.IOException;



public class HelloApplication extends Application {



    @Override
    public void start(Stage primarystage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primarystage.setTitle("The Circuit Corner");
        Image icon = new Image(getClass().getResourceAsStream("logo.jpg"));
        primarystage.getIcons().add(icon);
        primarystage.setScene(new Scene(root));
        primarystage.show();

        primarystage.setOnCloseRequest(event -> {
            event.consume();
            exitProgram(primarystage);
        });
    }

    public void exitProgram(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You're About to Exit The Program!!!");
        alert.setContentText("Are You Sure??");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You Successfully Exit From The Program");
            stage.close();
        }
    }


    public static void main(String[] args) {
        launch();


    }

}



