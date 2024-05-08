package org.caro.caroclient.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


import static org.caro.caroclient.controller.Utils.alertScene;
import static org.caro.caroclient.controller.Utils.goToScene;
import static org.caro.caroclient.model.UserManager.getUser;
import static org.caro.caroclient.model.UserManager.setListFriend;

public class HomeController implements Initializable {

    @FXML
    private ImageView avatarImage;

    @FXML
    private ImageView awardImage;

    @FXML
    private ImageView chatImage;
    @FXML
    private Button chatButton;

    @FXML
    private Button friendButton;

    @FXML
    private ImageView friendImage;

    @FXML
    private ImageView menuImage;

    @FXML
    private Button playNowButton;

    @FXML
    private Button playWithFriendButton;
    @FXML
    private Button rankButton;

    @FXML
    private Button settingButton;
    @FXML
    private Button menuButton;

    @FXML
    private ImageView settingImage;

    @FXML
    private Label userID;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuImage.setRotate(270);
        userID.setText("Name : "+ getUser().getUserName());
        setListFriend();
        playNowButton.setOnAction(actionEvent ->{
            goToScene("PlayAuto.fxml","Play now",playNowButton);
        });
        playWithFriendButton.setOnAction(actionEvent -> {
            goToScene("PlayWFriend.fxml","Let's Play",playWithFriendButton);
        });
        menuButton.setOnAction(actionEvent -> {
            alertScene("Menu.fxml", "menu");
        });
        chatButton.setOnAction(actionEvent -> {
            alertScene("Chat.fxml","Chatting");
        });
        rankButton.setOnAction(actionEvent -> {
            alertScene("XepHang.fxml", "Bang Xep Hang");
        });
        settingButton.setOnAction(actionEvent -> {
            alertScene("UserInfo.fxml","Thong tin");
        });
        friendButton.setOnAction(actionEvent -> {
            alertScene("ShowFriend.fxml","Danh sach ban be");
        });
    }




}
