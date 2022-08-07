package com.example.realfinalproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;

public class CreatePostController {
    Stage stage;
    Scene scene;
    Manager manager = new Manager();
    @FXML
    Button create;
    @FXML
    Button confirmPhoto;
    @FXML
    TextField postImage;
    @FXML
    TextArea postText;
    @FXML
    Label enterText;
    @FXML
    Label enterPhoto;
    @FXML
    ImageView imagePost;
    @FXML
    Button back;
    @FXML
    Pane pane;
    StringBuilder imageAddress = new StringBuilder();

    public void initialize() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (manager.checkLogin().getBackGround()!=null){
            Image img = new Image(manager.checkLogin().getBackGround());
            BackgroundImage bImg = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            pane.setBackground(bGround);
        }
    }
    public void setPostImage() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        imageAddress.append("C:\\Users\\APPLE\\Desktop\\posts\\");
        imageAddress.append(postImage.getText());
        imageAddress.append(".jpg");
        InputStream stream = new FileInputStream(imageAddress.toString());
        Image image = new Image(stream);
        imagePost.setImage(image);
    }
    public void setCreatePost(ActionEvent event) throws IOException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.createPost(postText.getText());
        String id = manager.checkLogin().getId() + manager.checkLogin().getPostIds().size();
        Post post = manager.searchPostById(id);
        if (!imageAddress.toString().equals("")) {
            post.setImage(imageAddress.toString());
        }
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
