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

public class LeaveCommentPageController {
    Manager manager=new Manager();
    Stage stage;
    Scene scene;
    @FXML
    TextArea comment;
    @FXML
    Button backToMainPage;
    @FXML
    Button leaveComment;
    @FXML
    Label label;
    @FXML
    Pane pane;
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
    public void setLeaveComment(ActionEvent event) throws IOException, SQLException
    {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Post post = null;

        if(MainPageController.mainPage)
        {
            post=MainPageController.post;
        }
        if(PreviousPostsController.prePostPage)
        {
            post=PreviousPostsController.post;
        }
        if (FriendsPostsController.followerPostPage)
        {
            post = FriendsPostsController.post;
        }
        if (SuggestBusinessPostPageController.suggestBusinessPost){
            post = SuggestBusinessPostPageController.businessPost;
        }
        if(commentPageController.commentPage)
        {
            post=commentPageController.post1;
        }
        assert post != null;
        String postId = post.getId();
        manager.addComment(postId,comment.getText());
        manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId = manager.checkLogin().getId();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void goToMainPage(ActionEvent event) throws IOException, SQLException
    {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
