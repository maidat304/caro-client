package org.caro.caroclient.model;


import org.caro.caroclient.controller.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDB {
    private static Boolean hasUser = false;
    private static String userName;
    private static String userId;
    private static String userPassword;

    public static void setUserName(String newUserName) {
        userName = newUserName;
    }

    public static void setUserId(String newUserId) {
        userId = newUserId;
    }

    public static void setUserPassword(String newUserPassword) {
        userPassword = newUserPassword;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static Boolean getHasUser() {
        return hasUser;
    }
    private static void setHasUser(Boolean x){
        hasUser = x;
    };

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
                setHasUser(true);

                if(getHasUser()){
                    setUserId(resultSet.getString("user_id"));
                    setUserName(resultSet.getString("username"));
                    setUserPassword(resultSet.getString("password"));
                };
            } else {
                System.out.println("User not found.");
            }

            resultSet.close();
            preparedStatement.close();
            connectDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}