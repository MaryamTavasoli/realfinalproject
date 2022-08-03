package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainPageController {
    Manager manager = new Manager();
    Stage stage;
    @FXML
    Label id;
    @FXML
    Label followerNumbers;
    @FXML
    Label followingNumber;
    @FXML
    Label showId;
    @FXML
    Label showFollowerNumbers;
    @FXML
    Label showFollowingNumbers;
    @FXML
    Rectangle rectangle;
    @FXML
    ImageView profile;
    @FXML
    Button close;

    public void initialize() throws FileNotFoundException {
        showId.setText(manager.checkLogin().getId());
        showFollowerNumbers.setText(Integer.toString(manager.checkLogin().getFollowers().size()));
        showFollowingNumbers.setText(Integer.toString(manager.checkLogin().getFollowings().size()));
        InputStream stream = new FileInputStream(SetImagePageController.str);
        Image image = new Image(stream);
        profile.setImage(image);
    }
    public void closeTheStage(ActionEvent event)
    {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        manager.logout();
    }
}
