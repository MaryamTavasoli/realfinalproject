package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotPageController {
    Manager manager = new Manager();
    Stage stage;
    Scene scene;
    @FXML
    Label id;
    @FXML
    Label nationalCode;
    @FXML
    TextField idField;
    @FXML
    TextField nationalCodeField;
    @FXML
    Button login;
    @FXML
    Button close;

    public void switchToMainPage(ActionEvent event) throws IOException {
        String[] splitInput = new String[4];
        splitInput[0] = "login";
        splitInput[1] = idField.getText();
        splitInput[2] = "forgot";
        splitInput[3] = nationalCodeField.getText();
        manager.login(splitInput);
        Parent root= FXMLLoader.load(getClass().getResource("mainPage.fxml"));
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
