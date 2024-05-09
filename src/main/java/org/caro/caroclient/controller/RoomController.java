package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomController implements Initializable {

    @FXML
    private Button findRoomButton;

    @FXML
    private TextField findRoomId;

    @FXML
    private TextField findRoomPass;

    @FXML
    private Button setRoomButton;
    @FXML
    private Button makeRoomButton;
    @FXML
    private Button findButton;

    @FXML
    private TextField setRoomPass;

    @FXML
    private AnchorPane showRoomId;
    @FXML
    private AnchorPane findRoomBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showRoomId.setVisible(true);
        findRoomBox.setVisible(false);

        findButton.setOnAction(actionEvent -> {
            showRoomId.setVisible(false);
            findRoomBox.setVisible(true);
        });

        makeRoomButton.setOnAction(actionEvent -> {
            showRoomId.setVisible(true);
            findRoomBox.setVisible(false);
        });

    }
}
