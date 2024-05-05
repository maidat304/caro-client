package org.caro.caroclient.model;


import org.caro.caroclient.controller.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private  Boolean hasUser = false;
    private  String userName;
    private  String userId;
    private  String userPassword;
    public List<UserDB> ListFriend = new ArrayList<>();


    public void setUserName(String newUserName) {
        userName = newUserName;
    }

    public void setUserId(String newUserId) {
        userId = newUserId;
    }

    public  void setUserPassword(String newUserPassword) {
        userPassword = newUserPassword;
    }

    public  String getUserName() {
        return userName;
    }

    public  String getUserId() {
        return userId;
    }

    public  String getUserPassword() {
        return userPassword;
    }

    public  Boolean getHasUser() {
        return hasUser;
    }
    public   void setHasUser(Boolean x){
        hasUser = x;
    };


}