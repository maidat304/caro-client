package org.caro.caroclient.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private Button colorButton;

    @FXML
    private AnchorPane colorPanel;

    @FXML
    private Button helpButton;

    @FXML
    private AnchorPane helpPanel;

    @FXML
    private Button musicButton;

    @FXML
    private AnchorPane musicPanel;
    @FXML
    private Button cancelButton;
    @FXML
    private Slider slideBar;

    @FXML
    private Button uploadMusicButton;

    @FXML
    private Label volumeLabel;

    @FXML
    private RadioButton customeButton;

    @FXML
    private RadioButton defaultButton;
    @FXML
    private TextArea feedBack;
    @FXML
    private RadioButton lightButton;

    @FXML
    private RadioButton darkButton;

    @FXML
    private RadioButton button1;

    @FXML
    private RadioButton button2;

    @FXML
    private RadioButton button3;
    @FXML
    private Button sendButton;


    @FXML
    void colorButtonOnAction(ActionEvent event) {
        colorButton.setStyle(colorButton.getStyle() +"-fx-border-color: #008DDA; -fx-text-fill: #008DDA;");
        musicButton.setStyle(musicButton.getStyle() + "-fx-border-color: white; -fx-text-fill: white;");
        helpButton.setStyle(helpButton.getStyle() +"-fx-border-color: white; -fx-text-fill: white;");


        musicPanel.setVisible(false);
        helpPanel.setVisible(false);
        colorPanel.setVisible(true);
    }

    @FXML
    void helpButtonOnAction(ActionEvent event) {
        helpButton.setStyle(helpButton.getStyle() + "-fx-border-color: #008DDA; -fx-text-fill: #008DDA;");
        musicButton.setStyle(musicButton.getStyle() + "-fx-border-color: white; -fx-text-fill: white;");
        colorButton.setStyle(colorButton.getStyle() + "-fx-border-color: white; -fx-text-fill: white;");

        colorPanel.setVisible(false);
        musicPanel.setVisible(false);
        helpPanel.setVisible(true);
    }

    @FXML
    void musicButtonOnAction(ActionEvent event) {
        musicButton.setStyle(musicButton.getStyle() + "-fx-border-color: #008DDA; -fx-text-fill: #008DDA;");
        colorButton.setStyle(colorButton.getStyle() +"-fx-border-color: white; -fx-text-fill: white;");
        helpButton.setStyle(helpButton.getStyle() +"-fx-border-color: white; -fx-text-fill: white;");

        colorPanel.setVisible(false);
        helpPanel.setVisible(false);
        musicPanel.setVisible(true);
    }

    public MenuController(){
    }

    ToggleGroup helpGroup = new ToggleGroup();
    ToggleGroup themeGroup = new ToggleGroup();
    ToggleGroup musicGroup = new ToggleGroup();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancelButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        });

        // phan am thanh
        slideBar.setValue(20);
        volumeLabel.setText(20+"%");
        slideBar.setOnMouseReleased(event -> {
            Double value = slideBar.valueProperty().getValue();
           volumeLabel.setText(value+"%");
        });

        customeButton.setToggleGroup(musicGroup);
        defaultButton.setToggleGroup(musicGroup);

        //phan help
        button1.setToggleGroup(helpGroup);
        button2.setToggleGroup(helpGroup);
        button3.setToggleGroup(helpGroup);


        // phan color
        lightButton.setToggleGroup(themeGroup);
        darkButton.setToggleGroup(themeGroup);


    }

    public void sendFeedBack(){
        RadioButton subButton = (RadioButton) helpGroup.getSelectedToggle();
        if(subButton!=null){
            System.out.println("<"+subButton.getText() + ">" + feedBack.getText().trim());

        }else{
            System.out.println("<khong xac dinh van de >" + feedBack.getText().trim());
        }
        feedBack.clear();
    }
}

