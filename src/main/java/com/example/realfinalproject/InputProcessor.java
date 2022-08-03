package com.example.realfinalproject;

import java.util.Scanner;

public class InputProcessor {
    private Scanner sc=new Scanner(System.in);
    public void start()
    {
        Manager manager=new Manager();
        while(true)
        {
            String input=sc.nextLine();
            if(input.contains("register"))
            {
                String[] splitInput=input.split("\\s");
                manager.register(splitInput);
            }
            if (input.contains("login"))
            {
                if (manager.checkLogin()==null) {
                    String[] splitInput = input.split("\\s");
                    manager.login(splitInput);
                }
            }
            if(input.contains("show")&&input.contains("profile"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput=input.split("\\s");
                    manager.showProfile(splitInput);
                }
            }
            if (input.contains("create post"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    manager.createPost();
                }
            }
            if(input.contains("add comment"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput=input.split("\\s");
                    manager.addComment(splitInput);
                }
            }
            if(input.contains("LIKE"))
            {
                if (manager.checkLogin()==null){
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput=input.split("\\s");
                    manager.like(splitInput);
                }
            }
            if (input.contains("show comments")) {
                if (manager.checkLogin() == null) {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.showComments(splitInput);
                }
            }
            if(input.contains("show likes")) {
                if (manager.checkLogin() == null) {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.showLikes(splitInput);
                }
            }
            if(input.contains("show main page"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    manager.showMainPage();
                }
            }
            if (input.contains("show stats"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.showStats(splitInput);
                }
            }
            if(input.contains("start private message"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.startPrivateMessage(splitInput);
                }
            }
            if (input.contains("forward message"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.forwardMessage(splitInput);
                }
            }
            if (input.contains("reply message"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.replyMessage(splitInput);
                }
            }
            if (input.contains("block"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.block(splitInput);
                }
            }
            if (input.contains("edit message"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.editMessage(splitInput);
                }
            }
            if (input.contains("show chats"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.showChats(splitInput);
                }
            }
            if (input.contains("create group")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.createGroup(splitInput);
                }
            }
            if (input.contains("add user")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.addUser(splitInput);
                }
            }
            if (input.contains("change groupName")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.changeGroupName(splitInput);
                }
            }
            if (input.contains("change groupId")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.changeGroupId(splitInput);
                }
            }
            if (input.contains("remove user")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.removeUser(splitInput);
                }
            }
            if (input.contains("ban user")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    String[] splitInput = input.split("\\s");
                    manager.banUser(splitInput);
                }
            }
            if(input.contains("send message to group"))
            {
                if(manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.sendGroupMessage(splitInput);
                }
            }
            if(input.contains("edit groupMessage"))
            {
                if(manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.editGroupMessage(splitInput);
                }
            }
            if(input.contains("reply groupMessage"))
            {
                if(manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.replyGroupMessage(splitInput);
                }

            }
            if(input.contains("forward groupMessage to group"))
            {
                if(manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.forwardGroupMessage(splitInput);
                }
            }
            if(input.contains("show group chats"))
            {
                if(manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.showGroupMessages(splitInput);
                }
            }
            if (input.contains("forward groupMessage to pv"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.forwardGroupToPv(splitInput);
                }
            }
            if (input.contains("forward ordinaryMessage to group"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    String[] splitInput = input.split("\\s");
                    manager.forwardPvToGroup(splitInput);
                }
            }
            if (input.contains("search text message"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else
                {
                    manager.searchTextMessage();
                }
            }
            if(input.contains("suggest friend")){
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else{
                    manager.suggestFriend();
                }
            }
            if(input.contains("suggest advertisement"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else{
                    manager.suggestBusinessPost();
                }
            }
            if(input.contains("log out"))
            {
                if (manager.checkLogin()==null)
                {
                    System.out.println("no one logged in...");
                }
                else {
                    manager.logout();
                }
            }
            if(input.equals("end"))
            {
                break;
            }
        }
    }
}