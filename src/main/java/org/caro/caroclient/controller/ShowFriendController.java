package org.caro.caroclient.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

import static org.caro.caroclient.controller.Utils.goToScene;
import static org.caro.caroclient.model.UserManager.getListFriendNames;
import static org.caro.caroclient.model.UserManager.setListFriend;

public class ShowFriendController implements Initializable {

    @FXML
    private Button addFriendButton;

    @FXML
    private ScrollPane showArea;

    @FXML
    private TextField textNeedFind;

    @FXML
    private VBox showBox;
    @FXML
    private Button findButton;
    @FXML
    private Button showListButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showBox.setSpacing(10);

       for(String fname : getListFriendNames()){
            themBox(fname,showBox);
       }
       showListButton.setOnAction(actionEvent -> {
         for(String name : getListFriendNames()){
             themBox(name, showBox);
         }

       });
       addFriendButton.setOnAction(actionEvent -> {
      showBox.getChildren().clear();
       });
       textNeedFind.textProperty().addListener(new ChangeListener<String>() {//tao doi tuong listener moi
           @Override
        public void changed(ObservableValue<? extends String> name, String oldValue, String newValue) {
               System.out.println("change");
               find(newValue);
        }

       });
       findButton.setOnAction(actionEvent -> {
           find(textNeedFind.getText());
       });
    }
    private void find(String findName){
        showBox.getChildren().clear();
        for (String name : getListFriendNames()){
            if(name.contains(findName)){
                themBox(name,showBox);
            }
        }
    }
    public void themBox(String name, VBox boxName){
        Image iconMess = new Image(getClass().getResourceAsStream("/Images/messenger.png"));
        HBox friendBox = new HBox();
        friendBox.setPrefHeight(45);
        friendBox.setAlignment(Pos.CENTER);
        friendBox.setStyle("-fx-background-radius : 5px; -fx-border-radius : 5px; -fx-border-color : black;");

        Label friendsName = new Label(name);
        friendsName.setPrefWidth(200);
        Label friendsState = new Label("offline");
        friendsState.setPrefWidth(66);

        ImageView iconInChatButton = new ImageView(iconMess);
        iconInChatButton.setFitHeight(20);
        iconInChatButton.setFitWidth(20);

        Button chatButtons = new Button();
        chatButtons.setStyle("-fx-background-color: transparent;");
        chatButtons.setGraphic(iconInChatButton);
        chatButtons.setOnAction(actionEvent -> {
            goToScene("Chat.fxml","Chatting",chatButtons);
        });

        friendBox.getChildren().add(friendsName);
        friendBox.getChildren().add(friendsState);
        friendBox.getChildren().add(chatButtons);

        boxName.getChildren().add(friendBox);
    }

}