package org.caro.caroclient.model;

import org.caro.caroclient.controller.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserDB user = new UserDB();


    public UserManager(UserDB newUser){
        this.user = newUser;
    }
    public UserManager(String userName, String userPassword){
        this.user.setUserName(userName);
        this.user.setUserPassword(userPassword);
    }

    public static String getNameUser(){
        return user.getUserName();
    }
    public static void getUserInfo(String username, String password) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getConnection();

            String getUserInfoQuery = "SELECT user_id, username, password FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connectDB.prepareStatement(getUserInfoQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Lấy thông tin từ ResultSet dat vao variables
                user.setHasUser(true);

                if(user.getHasUser()){
                    user.setUserId(resultSet.getString("user_id"));
                    user.setUserName(resultSet.getString("username"));
                    user.setUserPassword(resultSet.getString("password"));
                }else {
                System.out.println("User not found.");
                    user.setHasUser(false);
                }
                resultSet.close();
                preparedStatement.close();
                connectDB.close();
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Boolean hasUser(){
        return user.getHasUser();
    }

    public static void setListFriend(){
        StringBuilder result = new StringBuilder();
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getConnection();

            String Query = "SELECT u.user_id, u.username " +
                    "FROM users u " +
                    "JOIN friendships f ON u.user_id = f.user_id2 " +
                    "WHERE f.user_id1 = ? " +
                    "UNION " +
                    "SELECT u.user_id, u.username " +
                    "FROM users u JOIN friendships f ON u.user_id = f.user_id1 " +
                    "WHERE f.user_id2 = ?";


            PreparedStatement preparedStatement = connectDB.prepareStatement(Query);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUserId());


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserDB friends = new UserDB();
                friends.setUserId(resultSet.getString("user_id"));
                friends.setUserName(resultSet.getString("username"));
                user.ListFriend.add(friends);
            }

            resultSet.close();
            preparedStatement.close();
            connectDB.close();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public static List<String> getListFriendNames(){
        List<String> list = new ArrayList<String>();
        for(UserDB friend : user.ListFriend){
            list.add(friend.getUserName());
        }
        return list;
    }
}
