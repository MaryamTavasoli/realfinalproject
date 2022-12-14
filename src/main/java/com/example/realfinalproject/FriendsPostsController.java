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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class FriendsPostsController {
    Manager manager = new Manager();
    Stage stage;
    Scene scene;
    @FXML
    ImageView post1Image;
    @FXML
    ImageView post2Image;
    @FXML
    ImageView post3Image;
    @FXML
    Text post1Text;
    @FXML
    Text post2Text;
    @FXML
    Text post3Text;
    @FXML
    TextField followerId;
    @FXML
    Button confirm;
    @FXML
    Label idNotFound;
    @FXML
    Button back;
    @FXML
    Button like1;
    @FXML
    Button comment1;
    @FXML
    Button like2;
    @FXML
    Button comment2;
    @FXML
    Button like3;
    @FXML
    Button comment3;
    @FXML
    Label label;
    @FXML
    Label like1Label;
    @FXML
    Label like2Label;
    @FXML
    Label like3Label;
    @FXML
    ImageView profileImage;
    @FXML
    Label idLabel;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Pane pane;
    public static boolean followerPostPage = false;
    public static Post post;
    public static Post post1;
    public static Post post2;
    public static Post post3;
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
        like1.setVisible(false);
        comment1.setVisible(false);
        like2.setVisible(false);
        comment2.setVisible(false);
        like3.setVisible(false);
        comment3.setVisible(false);
        like1Label.setVisible(false);
        like2Label.setVisible(false);
        like3Label.setVisible(false);
    }
    public void goToMainPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showPosts() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String id = followerId.getText();
        if (manager.findId(id)==null){
            idNotFound.setText("id not found");
        }
        else if (!manager.checkLogin().followerIds.contains(manager.findId(id).getId()) && !manager.checkLogin().followingIds.contains(manager.findId(id).getId())){
            idNotFound.setText("friend not found");
        }
        else{
            User user = manager.findId(id);
            idLabel.setText(user.getId());
            InputStream stream = new FileInputStream(user.getImageAddress());
            Image image = new Image(stream);
            profileImage.setImage(image);
            ArrayList<String> suitablePosts=new ArrayList<>();
            for (int i = 0; i <user.getPostIds().size(); i++) {
                boolean bool=true;
                for (int i1 = 0; i1 < Manager.posts.size(); i1++) {
                    if(Manager.posts.get(i1).commentsId.contains(user.getPostIds().get(i)))
                    {
                        bool=false;
                        break;
                    }

                }
                if(bool)
                {
                    suitablePosts.add(user.getPostIds().get(i));
                }
            }
            if (suitablePosts.size()>=1){
                post1 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 1));
                InputStream stream1 = new FileInputStream(post1.getImage());
                Image image1 = new Image(stream1);
                post1Image.setImage(image1);
                post1Text.setText(post1.getText());
                ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
                imageView1.setFitHeight(25);
                imageView1.setFitWidth(30);
                like1.setGraphic(imageView1);
                like1.setVisible(true);
                ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
                imageView2.setFitHeight(25);
                imageView2.setFitWidth(30);
                comment1.setGraphic(imageView2);
                comment1.setVisible(true);
                like1Label.setText("likes:" + post1.getLikeUsersId().size());
                like1Label.setVisible(true);
            }
            if (suitablePosts.size()>=2){
                post2 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 2));
                InputStream stream2 = new FileInputStream(post2.getImage());
                Image image2 = new Image(stream2);
                post2Image.setImage(image2);
                post2Text.setText(post2.getText());
                ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
                imageView1.setFitHeight(25);
                imageView1.setFitWidth(30);
                like2.setGraphic(imageView1);
                like2.setVisible(true);
                ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
                imageView2.setFitHeight(25);
                imageView2.setFitWidth(30);
                comment2.setGraphic(imageView2);
                comment2.setVisible(true);
                like2Label.setText("likes:" + post2.getLikeUsersId().size());
                like2Label.setVisible(true);
            }
            if (suitablePosts.size()>=3){
                post3 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 3));
                InputStream stream3 = new FileInputStream(post3.getImage());
                Image image3 = new Image(stream3);
                post3Image.setImage(image3);
                post3Text.setText(post3.getText());
                ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
                imageView1.setFitHeight(25);
                imageView1.setFitWidth(30);
                like3.setGraphic(imageView1);
                like3.setVisible(true);
                ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
                imageView2.setFitHeight(25);
                imageView2.setFitWidth(30);
                comment3.setGraphic(imageView2);
                comment3.setVisible(true);
                like3Label.setText("likes:" + post3.getLikeUsersId().size());
                like3Label.setVisible(true);
            }
            if (user.getBusinessAccount().equals("business")){
                if (suitablePosts.size()>=1){
                    Post post1 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 1));
                    BusinessPost businessPost1 = (BusinessPost) post1;
                    if(!businessPost1.getViewers().contains(manager.checkLogin().getId()))
                    {
                        businessPost1.getViewers().add(manager.checkLogin().getId());
                        businessPost1.views.put(manager.checkLogin(), LocalDate.now());
                        businessPost1.viewUsersForTable.add(manager.checkLogin().getId());
                        businessPost1.viewLocalDatesForTable.add(LocalDate.now());
                    }
                    label1.setText("views: "+businessPost1.getViewers().size());

                }
                if (suitablePosts.size()>=2){
                    Post post2 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 2));
                    BusinessPost businessPost2 = (BusinessPost) post2;
                    if(!businessPost2.getViewers().contains(manager.checkLogin().getId()))
                    {
                        businessPost2.getViewers().add(manager.checkLogin().getId());
                        businessPost2.views.put(manager.checkLogin(), LocalDate.now());
                        businessPost2.viewUsersForTable.add(manager.checkLogin().getId());
                        businessPost2.viewLocalDatesForTable.add(LocalDate.now());
                    }
                    label2.setText("views: "+businessPost2.getViewers().size());
                }
                if (suitablePosts.size()>=3){
                    Post post3 = manager.searchPostById(suitablePosts.get(suitablePosts.size() - 3));
                    BusinessPost businessPost3 = (BusinessPost) post3;
                    if(!businessPost3.getViewers().contains(manager.checkLogin().getId()))
                    {
                        businessPost3.getViewers().add(manager.checkLogin().getId());
                        businessPost3.views.put(manager.checkLogin(), LocalDate.now());
                        businessPost3.viewUsersForTable.add(manager.checkLogin().getId());
                        businessPost3.viewLocalDatesForTable.add(LocalDate.now());
                    }
                    label3.setText("views: "+businessPost3.getViewers().size());
                }
            }
        }
    }
    public void setLike1() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (!post1.getLikeUsersId().contains(manager.checkLogin().getId())) {
            post1.getLikeUsersId().add(manager.checkLogin().getId());
            like1Label.setText("likes:" + post1.getLikeUsersId().size());
        }
        User user=manager.findId(post1.userId);
        if(user.getBusinessAccount().equals("business"))
        {
            BusinessPost businessPost1 = (BusinessPost) post1;
            if(!businessPost1.likes.containsKey(manager.checkLogin()))
            {
                businessPost1.likes.put(manager.checkLogin(), LocalDate.now());
                businessPost1.likesUsersForTable.add(manager.checkLogin().getId());
                businessPost1.likesLocalDateForTable.add(LocalDate.now());
            }
        }
    }
    public void setLike2() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (!post2.getLikeUsersId().contains(manager.checkLogin().getId())) {
            post2.getLikeUsersId().add(manager.checkLogin().getId());
            like2Label.setText("likes:" + post2.getLikeUsersId().size());
        }
        User user=manager.findId(post2.userId);
        if(user.getBusinessAccount().equals("business"))
        {
            BusinessPost businessPost2 = (BusinessPost) post2;
            if(!businessPost2.likes.containsKey(manager.checkLogin()))
            {
                businessPost2.likes.put(manager.checkLogin(), LocalDate.now());
                businessPost2.likesUsersForTable.add(manager.checkLogin().getId());
                businessPost2.likesLocalDateForTable.add(LocalDate.now());
            }
        }
    }
    public void setLike3() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (!post3.getLikeUsersId().contains(manager.checkLogin().getId())) {
            post3.getLikeUsersId().add(manager.checkLogin().getId());
            like3Label.setText("likes:" + post3.getLikeUsersId().size());
        }
        User user=manager.findId(post3.userId);
        if(user.getBusinessAccount().equals("business"))
        {
            BusinessPost businessPost3 = (BusinessPost) post3;
            if(!businessPost3.likes.containsKey(manager.checkLogin()))
            {
                businessPost3.likes.put(manager.checkLogin(), LocalDate.now());
                businessPost3.likesUsersForTable.add(manager.checkLogin().getId());
                businessPost3.likesLocalDateForTable.add(LocalDate.now());
            }
        }
    }
    public void goToCommentPage1(ActionEvent event) throws IOException, SQLException
    {
        MainPageController.mainPage=false;
        PreviousPostsController.prePostPage=false;
        followerPostPage = true;
        commentPageController.commentPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post=post1;
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToCommentPage2(ActionEvent event) throws IOException, SQLException
    {
        MainPageController.mainPage=false;
        PreviousPostsController.prePostPage=false;
        followerPostPage = true;
        commentPageController.commentPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post=post2;
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToCommentPage3(ActionEvent event) throws IOException, SQLException
    {
        MainPageController.mainPage=false;
        PreviousPostsController.prePostPage=false;
        followerPostPage = true;
        commentPageController.commentPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post=post3;
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
