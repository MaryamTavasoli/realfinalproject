package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterOrLoginController {
    Stage stage;
    Scene scene;
    @FXML
    Button register;
    @FXML
    Button login;
    @FXML
    Rectangle rectangle;
    @FXML
    Button close;

    public void switchToRegisterPage(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("registerPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoginPage(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeTheStage(ActionEvent event)
    {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
