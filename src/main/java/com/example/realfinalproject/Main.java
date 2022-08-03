package com.example.realfinalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project",
                "root", "12345");
        DatabaseInitializer databaseInitializer=new DatabaseInitializer();
        DataInitializer dataInitializer=new DataInitializer();
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setUserArrayList(connection);
        InputProcessor inputProcessor=new InputProcessor();
        databaseInitializer.createTables(connection);
        inputProcessor.start();
        dataInitializer.insertUsers(connection);
        dataInitializer.insertPosts(connection);
        dataInitializer.insertMessages(connection);
        dataInitializer.insertGroupMessage(connection);
        dataInitializer.insertGroup(connection);
        dataInitializer.insertBlocks(connection);
        dataInitializer.insertBusinessPost(connection);
        System.out.println(Manager.users.size());
    }

    @Override
    public void start(Stage stage){
        try {
            Parent root= FXMLLoader.load((Objects.requireNonNull(getClass().getResource("LoginOrRegister.fxml"))));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
