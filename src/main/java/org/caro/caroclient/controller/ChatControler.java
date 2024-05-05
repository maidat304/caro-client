package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static org.caro.caroclient.model.UserManager.*;


public class ChatControler implements Initializable {
    public VBox messageArea;

    @FXML
    private TextField textField;

    @FXML
    private Label friendsNameLabel;

    @FXML
    private Button sendButton;

    @FXML
    private VBox viewArea;
    @FXML
    private ScrollPane scrollMessageArea;
    public ChatControler(){
        //lay thong tin friend

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setListFriend();
        System.out.println("da lay thong tin ban be");
        for(String name : getListFriendNames()){
            HBox friendInfoView = new HBox();
            friendInfoView.setOnMouseClicked(mouseEvent -> {
                sendMessageToFriend(friendInfoView);
            });
            ImageView friendAvatar = new ImageView(new Image(getClass().getResourceAsStream("/Images/naruto.png")));

            friendInfoView.setPrefHeight(45);
            friendInfoView.setPrefWidth(173);
            friendInfoView.setStyle("-fx-background-color : #9bdcff;");

            friendAvatar.setFitWidth(45);
            friendAvatar.setFitHeight(45);

            Label friendNameLabel = new Label();
            friendNameLabel.setText("" + name);
            friendNameLabel.setStyle("-fx-font-size: 14px;");
            friendNameLabel.setAlignment(Pos.CENTER);

            friendInfoView.getChildren().add(friendAvatar);
            friendInfoView.getChildren().add(friendNameLabel);
            viewArea.getChildren().add(friendInfoView);
        }
    }

    private void sendMessageToFriend(HBox friendInfoView){
        if(messageArea != null) {
            messageArea.getChildren().clear();
        }
        String friendsName = ((Label) friendInfoView.getChildren().get(1)).getText(); //lay phan tu thu2 cua hbox, ep kieu label de xai getText
        friendsNameLabel.setText(friendsName);

        sendButton.setOnAction(actionEvent -> {
            String content = textField.getText();
            Label newMessage = new Label();
            newMessage.setStyle("-fx-font-size : 14px;" );
            newMessage.setText("<You> : "+ content);
            if(!content.isEmpty()){
                messageArea.getChildren().add(newMessage);
                textField.clear();
                scrollMessageArea.setVvalue(1.0);
            }
        });

    }
}
