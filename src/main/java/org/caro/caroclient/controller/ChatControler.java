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
import javafx.scene.input.KeyCode;
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
    @FXML
    private Button addFriendButton;

    @FXML
    private Button findButton;
    public ChatControler(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageArea.setSpacing(10);
        textField.getStylesheets().add("-fx-text-fill: white;");
        //them ban be vao vbox
        for(String name : getListFriendNames()){
            HBox friendInfoView = new HBox();
            friendInfoView.setSpacing(10);
            friendInfoView.setStyle("-fx-border-color : white;");
            friendInfoView.setOnMouseClicked(mouseEvent -> {
                sendMessageToFriend(friendInfoView);
            });
            ImageView friendAvatar = new ImageView(new Image(getClass().getResourceAsStream("/Images/naruto.png")));

            friendInfoView.setPrefHeight(45);
            friendInfoView.setPrefWidth(173);

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
            send();
        });
        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                send();
                event.consume();
            }
        });

    }
    public void send(){
        String content = textField.getText();
        Label newMessage = new Label();
        newMessage.setStyle("-fx-font-size : 14px;" );
        newMessage.setText("<You> : "+ content);
        if(!content.isEmpty()){
            messageArea.getChildren().add(newMessage);
            textField.clear();
            scrollMessageArea.setVvalue(1.0);
        }
    }
}
