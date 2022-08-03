package com.example.realfinalproject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public void createTables(Connection connection) throws SQLException{
        initUserTable(connection.createStatement());
        initPostTable(connection.createStatement());
        initMessageTable(connection.createStatement());
        initGroupMessageTable(connection.createStatement());
        initGroupTable(connection.createStatement());
        initBlock(connection.createStatement());
        initBusinessPost(connection.createStatement());
    }

    private void initUserTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "User(id varchar(20) PRIMARY KEY," +
                "password varchar(20),entered boolean,nationalCode varchar(20),businessAccount varchar(20)," +
                "followers varchar(100),followings varchar(100),posts varchar(100),messages varchar(100)," +
                "allFriends varchar(100))");
    }

    private void initPostTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "Post(id varchar(20) PRIMARY KEY,postText varchar(20)," +
                "postUser varchar(20),likeUsers varchar(20),comments varchar(20))");
    }

    private void initMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "Message(id int PRIMARY KEY,messageText varchar(20)," +
                "forwarded boolean,localDate varchar(20),sender varchar(20),receiver varchar(20))");
    }
    private void initGroupMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "GroupMessage(id varchar(20) PRIMARY KEY,groupText varchar(20)," +
                "localDate varchar(20),grp varchar(20),sender varchar(20))");
    }
    private void initGroupTable(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "Grp(id varchar(20) PRIMARY KEY,name varchar(20),admin varchar(20)," +
                "users varchar(20),banned varchar(20),groupMessage varchar(20))");
    }
    private void initBlock(Statement statement) throws SQLException{
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "BlockUser(id " +
                "int PRIMARY KEY,blocker varchar(20),blocked varchar(20))");
    }
    private void initBusinessPost(Statement statement) throws SQLException{
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + "businessPost(id varchar(20) PRIMARY KEY,postText varchar(20)," +
                "postUser varchar(20),likeUsers varchar(20),comments varchar(20),viewers varchar(20),releasedTime varchar(20)," +
                "likes varchar(20),views varchar(20),favoriteNumbers varchar(20))");
    }
}
