package com.example.realfinalproject;

import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class SetArrayLists {
    Manager manager = new Manager();
    public void setUserArrayList(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from User");
        while (resultSet.next()) {
            ArrayList<User> followers = new ArrayList<>();
            ArrayList<User> followings = new ArrayList<>();
            ArrayList<Post> posts = new ArrayList<>();
            ArrayList<Message> messages = new ArrayList<>();
            ArrayList<User> allFriends = new ArrayList<>();
            String[] splitInputFollowers = resultSet.getString("followers").split("-");
            String[] splitInputFollowings = resultSet.getString("followings").split("-");
            String[] splitInputPosts = resultSet.getString("posts").split("-");
            String[] splitInputMessages = resultSet.getString("messages").split("-");
            String[] splitInputAllFriends = resultSet.getString("allFriends").split("-");
            String follower = resultSet.getString("followers");
            String following = resultSet.getString("followings");
            String post = resultSet.getString("posts");
            String message = resultSet.getString("messages");
            String friend = resultSet.getString("allFriends");
            if (follower.contains("-")) {
                for (int i = 0; i < splitInputFollowers.length; i++) {
                    followers.add(manager.findId(splitInputFollowers[i]));
                }
            }
            if (following.contains("-")) {
                for (int i = 0; i < splitInputFollowings.length; i++) {
                    followings.add(manager.findId(splitInputFollowings[i]));
                }
            }
            if (post.contains("-")) {
                for (int i = 0; i < splitInputPosts.length; i++) {
                    posts.add(manager.searchPostById(splitInputPosts[i]));
                }
            }
            if (message.contains("-")) {
                for (int i = 0; i < splitInputMessages.length; i++) {
                    messages.add(manager.searchMessage(Integer.parseInt(splitInputMessages[i])));
                }
            }
            if (friend.contains("-")) {
                for (int i = 0; i < splitInputAllFriends.length; i++) {
                    allFriends.add(manager.findId(splitInputAllFriends[i]));
                }
            }
            User user = new User(
                    resultSet.getString("id"), resultSet.getString("password"),
                    resultSet.getBoolean("entered"),resultSet.getString("nationalCode"),
                    resultSet.getString("businessAccount"), followers,followings,posts,messages,allFriends);
            manager.users.add(user);
            if (resultSet.getString("businessAccount").equals("business")){
                BusinessUser businessUser = new BusinessUser(resultSet.getString("id"), resultSet.getString("password"),
                        resultSet.getBoolean("entered"),resultSet.getString("nationalCode"),
                        resultSet.getString("businessAccount"), followers,followings,posts,messages,allFriends);
                manager.businessUsers.add(businessUser);
            }
        }
        statement.close();
    }
    public void setPostsArrayList(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Post");
        while (resultSet.next()){
            ArrayList<User> likeUsers = new ArrayList<>();
            ArrayList<Post> comments = new ArrayList<>();
            String[] splitInputLikeUsers = resultSet.getString("likeUsers").split("-");
            String[] splitInputComments = resultSet.getString("comments").split("-");
            String likes = resultSet.getString("likeUsers");
            String comment = resultSet.getString("comments");
            if (likes.contains("-")){
                for (int i=0;i< splitInputLikeUsers.length;i++){
                    likeUsers.add(manager.findId(splitInputLikeUsers[i]));
                }
            }
            if (comment.contains("-")){
                for (int i=0;i< splitInputComments.length;i++){
                    comments.add(manager.searchPostById(splitInputComments[i]));
                }
            }
            Post post = new Post(manager.findId(resultSet.getString("postUser")), resultSet.getString("id"),
                    resultSet.getString("postText"),likeUsers,comments);
            manager.posts.add(post);
        }
        statement.close();
    }
    public void setMessagesArrayList(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from message");
        while (resultSet.next()){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = resultSet.getString("localDate");
            LocalDate localDate = LocalDate.parse(date, formatter);
            Message message = new Message(manager.findId(resultSet.getString("sender")),resultSet.getString("text"),
                    manager.findId(resultSet.getString("receiver")),Integer.parseInt(resultSet.getString("id")),
                    resultSet.getBoolean("forwarded"), localDate);
            manager.messages.add(message);
        }
        statement.close();
    }
    public void setBlockArrayList(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from blockUser");
        while (resultSet.next()){
            Block block = new Block(manager.findId(resultSet.getString("blocker")),
                    manager.findId(resultSet.getString("blocked")));
            manager.blocks.add(block);
        }
        statement.close();
    }
    public void setGroupArrayList(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from grp");
        while (resultSet.next())
        {
            ArrayList<User>users=new ArrayList<>();
            ArrayList<Boolean>banned=new ArrayList<>();
            ArrayList<GroupMessage>groupMessages=new ArrayList<>();
            String[] splitInputUsers=resultSet.getString("users").split("-");
            String[] splitInputBanned=resultSet.getString("banned").split("-");
            String[] splitInputGroupMessages=resultSet.getString("groupMessage").split("-");
            String user=resultSet.getString("users");
            String bann=resultSet.getString("banned");
            String groupMessage=resultSet.getString("groupMessage");
            if(user.contains("-")) {
                for (int i = 0; i < splitInputUsers.length; i++) {
                    users.add(manager.findId(splitInputUsers[i]));
                }
            }
            if(bann.contains("-"))
            {
                for (int i = 0; i < splitInputBanned.length; i++) {
                    banned.add(Boolean.parseBoolean(splitInputBanned[i]));
                }
            }
            if(groupMessage.contains("-"))
            {
                for (int i = 0; i < splitInputGroupMessages.length; i++) {
                    groupMessages.add(manager.findGroupMessage(splitInputGroupMessages[i]));
                }
            }
            Group group=new Group(manager.findId(resultSet.getString("admin")),resultSet.getString("name")
            ,resultSet.getString("id"),users,banned,groupMessages);
            manager.groups.add(group);
        }
        statement.close();
    }
    public void setGroupMessages(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from groupMessage");
        while (resultSet.next())
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = resultSet.getString("localDate");
            LocalDate localDate = LocalDate.parse(date, formatter);
            GroupMessage groupMessage=new GroupMessage(manager.findId(resultSet.getString("sender")),
                    resultSet.getString("groupText"),resultSet.getString("id"),
                manager.searchGroup(resultSet.getString("grp")),localDate);
            manager.groupMessages.add(groupMessage);
        }
        statement.close();
    }
    public void setBusinessPosts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from groupMessage");
        while (resultSet.next())
        {
            ArrayList<User>likeUsers=new ArrayList<>();
            String[] splitInputLikeUsers=resultSet.getString("likeUsers").split("-");
            String LikeUsers=resultSet.getString("likeUsers");
            if(LikeUsers.contains("-"))
            {
                for (int i = 0; i < splitInputLikeUsers.length; i++) {
                  likeUsers.add(manager.findId(splitInputLikeUsers[i]));  
                }
            }
            ArrayList<Post>comments=new ArrayList<>();
            String[] splitInputComments=resultSet.getString("comments").split("-");
            String Comments=resultSet.getString("comments");
            if(Comments.contains("-"))
            {
                for (int i = 0; i < splitInputComments.length; i++) {
                    comments.add(manager.searchPostById(splitInputComments[i]));
                }
            }
            ArrayList<User>viewers=new ArrayList<>();
            String[] splitInputViewers=resultSet.getString("viewers").split("-");
            String Viewers=resultSet.getString("viewers");
            if(Viewers.contains("-"))
            {
                for (int i = 0; i < splitInputViewers.length; i++) {
                    viewers.add(manager.findId(splitInputViewers[i]));
                }
            }
            HashMap<User,Double>favoriteNumbers=new HashMap<>();
            String[] splitInputFavoriteNumbers=resultSet.getString("favoriteNumbers").split("-");
            String FavoriteNumbers=resultSet.getString("favoriteNumbers");
            if(FavoriteNumbers.contains("-"))
            {
                for (int i = 0; i < splitInputFavoriteNumbers.length; i++) {
                    for (int j = 0; j < splitInputFavoriteNumbers[i].length(); j++) {
                        if(splitInputFavoriteNumbers[i].charAt(j)==',')
                        {
                            User user=manager.findId(splitInputFavoriteNumbers[i].substring(0,j));
                            Double number=Double.parseDouble(splitInputFavoriteNumbers[i].substring(j+1,splitInputFavoriteNumbers.length));
                            favoriteNumbers.put(user,number);
                        }

                    }

                    
                }
            }
            HashMap<User,LocalDate>likes=new HashMap<>();
            String[] splitInputLikes=resultSet.getString("likes").split("-");
            String Likes=resultSet.getString("likes");
            if(Likes.contains("-"))
            {
                for (int i = 0; i < splitInputLikes.length; i++) {
                    for (int j = 0; j < splitInputLikes[i].length(); j++) {
                        if(splitInputLikes[i].charAt(j)==',')
                        {
                            User user=manager.findId(splitInputLikes[i].substring(0,j));
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                            LocalDate localDate=LocalDate.parse(splitInputLikes[i].substring(j+1,splitInputLikes.length),formatter);
                            likes.put(user,localDate);
                        }

                    }


                }
            }
            HashMap<User,LocalDate>views=new HashMap<>();
            String[] splitInputViews=resultSet.getString("views").split("-");
            String Views=resultSet.getString("views");
            if(Views.contains("-"))
            {
                for (int i = 0; i < splitInputViews.length; i++) {
                    for (int j = 0; j < splitInputViews[i].length(); j++) {
                        if(splitInputViews[i].charAt(j)==',')
                        {
                            User user=manager.findId(splitInputViews[i].substring(0,j));
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                            LocalDate localDate=LocalDate.parse(splitInputViews[i].substring(j+1,splitInputViews.length),formatter);
                            views.put(user,localDate);
                        }

                    }


                }
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            String date = resultSet.getString("localDate");
            LocalDate localDate = LocalDate.parse(date, formatter);
            BusinessPost businessPost=new BusinessPost(manager.findId(resultSet.getString("postUser")),
                    resultSet.getString("id"),resultSet.getString("postText"),likeUsers,comments,
                    favoriteNumbers,viewers,likes,views,localDate);
            manager.businessPosts.add(businessPost);
        }
        statement.close();
    }
}