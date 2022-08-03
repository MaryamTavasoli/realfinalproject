package com.example.realfinalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataInitializer {
    Manager manager=new Manager();
    public void insertUsers(Connection connection) throws SQLException {
        int num = manager.users.size();
        ArrayList<User> users = manager.users;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into User values(" +
                    "?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, users.get(i).getId());
            preparedStatement.setString(2,users.get(i).getPassword());
            preparedStatement.setBoolean(3,users.get(i).isEntered());
            preparedStatement.setString(4,users.get(i).getNationalCode());
            preparedStatement.setString(5,users.get(i).getBusinessAccount());
            StringBuilder followerIds= new StringBuilder();
            for (int j=0;j<users.get(i).getFollowers().size();j++){
                followerIds.append(users.get(i).getFollowers().get(j).getId());
                followerIds.append("-");
            }
            preparedStatement.setString(6, followerIds.toString());
            StringBuilder followingIds= new StringBuilder();
            for (int j=0;j<users.get(i).getFollowings().size();j++){
                followingIds.append(users.get(i).getFollowings().get(j).getId());
                followingIds.append("-");
            }
            preparedStatement.setString(7, followingIds.toString());
            StringBuilder postIds= new StringBuilder();
            for(int j=0;j<users.get(i).getPosts().size();j++){
                postIds.append(users.get(i).getPosts().get(j).getId());
                postIds.append("-");
            }
            preparedStatement.setString(8, postIds.toString());
            StringBuilder messageIds= new StringBuilder();
            for (int j=0;j<users.get(i).getMessages().size();j++){
                messageIds.append(users.get(i).getMessages().get(j).getId());
                messageIds.append("-");
            }
            preparedStatement.setString(9, messageIds.toString());
            StringBuilder allFriends= new StringBuilder();
            for (int j=0;j<users.get(i).getAllFriends().size();j++){
                allFriends.append(users.get(i).getAllFriends().get(j).getId());
                allFriends.append("-");
            }
            preparedStatement.setString(10, allFriends.toString());
            preparedStatement.executeUpdate();
        }
    }
    public void insertPosts(Connection connection) throws SQLException
    {
        int num=manager.posts.size();
        ArrayList<Post> posts=manager.posts;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into Post values(?,?,?,?,?)");
            preparedStatement.setString(1,posts.get(i).getId());
            preparedStatement.setString(2,posts.get(i).getText());
            preparedStatement.setString(3,posts.get(i).getUser().getId());
            StringBuilder likeUsers= new StringBuilder();
            for (int j=0;j<posts.get(i).getLikeUsers().size();j++){
                likeUsers.append(posts.get(i).getLikeUsers().get(j).getId());
                likeUsers.append("-");
            }
            preparedStatement.setString(4,likeUsers.toString());
            StringBuilder commentIds= new StringBuilder();
            for (int j=0;j<posts.get(i).getComments().size();j++){
                commentIds.append(posts.get(i).getComments().get(j).getId());
                commentIds.append("-");
            }
            preparedStatement.setString(5,commentIds.toString());
            preparedStatement.executeUpdate();
        }
    }
    public void insertMessages(Connection connection) throws SQLException{
        int num=manager.messages.size();
        ArrayList<Message> messages=manager.messages;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into Message values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,messages.get(i).getId());
            preparedStatement.setString(2,messages.get(i).getText());
            preparedStatement.setBoolean(3,messages.get(i).forwarded);
            preparedStatement.setString(4,messages.get(i).localDateToString);
            preparedStatement.setString(5,messages.get(i).getSender().getId());
            preparedStatement.setString(6,messages.get(i).getReceiver().getId());
            preparedStatement.executeUpdate();
        }
    }
    public void insertGroupMessage(Connection connection) throws SQLException{
        int num = manager.groupMessages.size();
        ArrayList<GroupMessage> groupMessages = manager.groupMessages;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into GroupMessage values" +
                    "(?,?,?,?,?)");
            preparedStatement.setString(1,groupMessages.get(i).getId());
            preparedStatement.setString(2,groupMessages.get(i).getText());
            preparedStatement.setString(3,groupMessages.get(i).localDateToString);
            preparedStatement.setString(4,groupMessages.get(i).getGroup().getGroupId());
            preparedStatement.setString(5,groupMessages.get(i).getSender().getId());
            preparedStatement.executeUpdate();
        }
    }
    public void insertGroup(Connection connection) throws SQLException {
        int num = manager.groups.size();
        ArrayList<Group> groups = manager.groups;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into grp values" +
                    "(?,?,?,?,?,?)");
            preparedStatement.setString(1,groups.get(i).getGroupId());
            preparedStatement.setString(2,groups.get(i).getGroupName());
            preparedStatement.setString(3,groups.get(i).getAdmin().getId());
            StringBuilder users= new StringBuilder();
            for (int j=0;j<groups.get(i).getUsers().size();j++){
                users.append(groups.get(i).getUsers().get(j).getId());
                users.append("-");
            }
            preparedStatement.setString(4,users.toString());
            StringBuilder banned= new StringBuilder();
            for (int j=0;j<groups.get(i).getBanned().size();j++){
                banned.append(groups.get(i).getBanned().get(j).toString());
                banned.append("-");
            }
            preparedStatement.setString(5,banned.toString());
            StringBuilder groupMessageIds= new StringBuilder();
            for (int j=0;j<groups.get(i).getGroupMessages().size();j++){
                groupMessageIds.append(groups.get(i).getGroupMessages().get(j).getId());
                groupMessageIds.append("-");
            }
            preparedStatement.setString(6,groupMessageIds.toString());
            preparedStatement.executeUpdate();
        }
    }
    public void insertBlocks(Connection connection) throws SQLException {
        int num = manager.blocks.size();
        ArrayList<Block> blocks = manager.blocks;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into BlockUser values" +
                    "(?,?,?)");
            preparedStatement.setInt(1,i+1);
            preparedStatement.setString(2,blocks.get(i).getBlocker().getId());
            preparedStatement.setString(3,blocks.get(i).getBlocked().getId());
            preparedStatement.executeUpdate();
        }
    }
    public void insertBusinessPost(Connection connection) throws SQLException
    {
        int num = manager.businessPosts.size();
        ArrayList<BusinessPost> businessPosts = manager.businessPosts;
        for (int i=0;i<num;i++){
            PreparedStatement preparedStatement = connection.prepareStatement("insert ignore into BusinessPost values" +
                    "(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,businessPosts.get(i).getId());
            preparedStatement.setString(2,businessPosts.get(i).getText());
            preparedStatement.setString(3,businessPosts.get(i).getUser().getId());
            StringBuilder likeUsers = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).getLikeUsers().size();j++){
               likeUsers.append(businessPosts.get(i).getLikeUsers().get(j));
                likeUsers.append("-");
            }
            preparedStatement.setString(4,likeUsers.toString());
            StringBuilder comments = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).getComments().size();j++){
                comments.append(businessPosts.get(i).getComments().get(j));
                comments.append("-");
            }
            preparedStatement.setString(5,comments.toString());
            StringBuilder viewers = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).getViewers().size();j++){
                viewers.append(businessPosts.get(i).getViewers().get(j));
                viewers.append("-");
            }
            preparedStatement.setString(6,viewers.toString());
            preparedStatement.setString(7,businessPosts.get(i).releasedTime.toString());
            StringBuilder likes = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).likesUsersForTable.size();j++){
                likes.append(businessPosts.get(i).likesUsersForTable.get(j).getId());
                likes.append(",");
                likes.append(businessPosts.get(i).likesLocalDateForTable.get(j).toString());
                likes.append("-");
            }
            preparedStatement.setString(8,likes.toString());
            StringBuilder views = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).viewUsersForTable.size();j++){
                views.append(businessPosts.get(i).viewUsersForTable.get(j).getId());
                views.append(",");
                views.append(businessPosts.get(i).viewLocalDatesForTable.get(j).toString());
                views.append("-");
            }
            preparedStatement.setString(9,views.toString());
            StringBuilder favoriteNumbers = new StringBuilder();
            for (int j=0;j<businessPosts.get(i).favoriteNumbers.size();j++){
                favoriteNumbers.append(businessPosts.get(i).favoriteNumberUser.get(j).getId());
                favoriteNumbers.append(",");
                favoriteNumbers.append(businessPosts.get(i).favoriteNumberDouble.get(j).toString());
                favoriteNumbers.append("-");
            }
            preparedStatement.setString(10,favoriteNumbers.toString());
        }
    }
}