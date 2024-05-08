package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

import static org.caro.caroclient.model.UserManager.getUser;

public class UserInfoController implements Initializable {
    @FXML
    private Button changeInfoButton;

    @FXML
    private Label pointLabel;

    @FXML
    private Label rateLabel;

    @FXML
    private Label scrisptLabel;

    @FXML
    private Label userNameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name = userNameLabel.getText();
        userNameLabel.setText(name + getUser().getUserName());

    }
}
