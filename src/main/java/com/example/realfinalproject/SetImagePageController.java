package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class SetImagePageController {
    Stage stage;
    Scene scene;
    @FXML
    Rectangle rectangle;
    @FXML
    Label label;
    @FXML
    ImageView image1;
    @FXML
    ImageView image2;
    @FXML
    ImageView image3;
    @FXML
    ImageView image4;
    @FXML
    CheckBox checkBox1;
    @FXML
    CheckBox checkBox2;
    @FXML
    CheckBox checkBox3;
    @FXML
    CheckBox checkBox4;
    @FXML
    Button loginPage;
    public static String str="";
    public void initialize() throws FileNotFoundException
    {
        InputStream stream1 = new FileInputStream("C:\\Users\\APPLE\\Desktop\\images\\ali.jpg");
        Image Image1 = new Image(stream1);
        image1.setImage(Image1);
        InputStream stream2 = new FileInputStream("C:\\Users\\APPLE\\Desktop\\images\\mina.jpg");
        Image Image2 = new Image(stream2);
        image2.setImage(Image2);
        InputStream stream3 = new FileInputStream("C:\\Users\\APPLE\\Desktop\\images\\neda.jpg");
        Image Image3 = new Image(stream3);
        image3.setImage(Image3);
        InputStream stream4 = new FileInputStream("C:\\Users\\APPLE\\Desktop\\images\\reza.jpg");
        Image Image4= new Image(stream4);
        image4.setImage(Image4);
    }
    public void goToLoginPage(ActionEvent event) throws IOException {
        if (checkBox1.isSelected()) {
            str = "C:\\Users\\APPLE\\Desktop\\images\\image1.jpg";
        }
        if (checkBox2.isSelected()) {
            str ="C:\\Users\\APPLE\\Desktop\\images\\image2.jpg" ;
        }
        if (checkBox3.isSelected()) {
            str = "C:\\Users\\APPLE\\Desktop\\images\\image3.jpg";
        }
        if (checkBox4.isSelected()) {
            str = "C:\\Users\\APPLE\\Desktop\\images\\image4.jpg";
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginPage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
