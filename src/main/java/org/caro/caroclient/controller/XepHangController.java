package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.caro.caroclient.model.UserDB;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.caro.caroclient.model.UserManager.getTop;
import static org.caro.caroclient.model.UserManager.setUser;


public class XepHangController implements Initializable {
    @FXML
    private VBox pointBox;

    @FXML
    private VBox rankBox;

    @FXML
    private VBox userNameBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rankBox.setAlignment(Pos.CENTER);
        pointBox.setAlignment(Pos.CENTER);
        userNameBox.setAlignment(Pos.CENTER);


        List<UserDB> listTop = new ArrayList<UserDB>();
        int limit = 10;
        listTop = getTop(limit);
        for(int i =0; i<limit;i++){
        show(i + 1,listTop.get(i).getUserName(),listTop.get(i).getPoint());
        }
    }
    private void show(int rank, String name, int point){
        Label rankLabel = new Label(""+rank);
        Label nameLabel = new Label(name);
        Label pointLabel = new Label(""+point);

        rankBox.getChildren().add(rankLabel);
        userNameBox.getChildren().add(nameLabel);
        pointBox.getChildren().add(pointLabel);

    }

}
