package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    Stage stage;
    Scene scene;
    Manager manager = new Manager();
    @FXML
    Label id;
    @FXML
    Label password;
    @FXML
    Label repeatPassword;
    @FXML
    Label nationalCode;
    @FXML
    Label userType;
    @FXML
    TextField idField;
    @FXML
    PasswordField passwordField;
    @FXML
    PasswordField repeatPasswordField;
    @FXML
    TextField nationalCodeField;
    @FXML
    CheckBox ordinary;
    @FXML
    CheckBox business;
    @FXML
    Button register;
    @FXML
    Rectangle rectangle;
    @FXML
    Button close;
    public void setRegister(ActionEvent event) throws IOException
    {
        String[] splitInput = new String[6];
        splitInput[0] = "register";
        splitInput[1] = idField.getText();
        splitInput[2] = passwordField.getText();
        splitInput[3] = repeatPasswordField.getText();
        splitInput[4] = nationalCodeField.getText();
        if (ordinary.isSelected()){
            splitInput[5] = "ordinary";
        }
        else if (business.isSelected()){
            splitInput[5] = "business";
        }
        manager.register(splitInput);
        Parent root= FXMLLoader.load(getClass().getResource("setImagePage.fxml"));
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
