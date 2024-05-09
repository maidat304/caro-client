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
    private int point;
    private int turns;
    private String story;
    private int rate;


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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}