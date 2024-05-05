package org.caro.caroclient.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;

import static org.caro.caroclient.controller.Utils.goToScene;
import static org.caro.caroclient.model.UserManager.getUserInfo;
import static org.caro.caroclient.model.UserManager.hasUser;


public class LoginController implements Initializable {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label moveToRegister;
    @FXML
    private Button loginButton;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        moveToRegister.setOnMouseClicked(event -> {
            goToScene("register.fxml","Register", moveToRegister);
        });

    }
    public void loginButtonOnAction(ActionEvent event){
        loginButton.setOnMousePressed(mouseEvent -> {
            loginButton.setStyle("-fx-background-color : #DDF7F7");
        });
        if(!userNameField.getText().isBlank() && !passwordField.getText().isBlank()){
            validate();
        }else{
            loginMessageLabel.setText("Please enter user id and password");
        }
   }
   public void validate(){
       try{
           //kiem tra xem co user k + lay thong tin user
           getUserInfo(userNameField.getText(), passwordField.getText());
           //neu co user
           if(hasUser()){
               loginMessageLabel.setText("success!");
               loginMessageLabel.setStyle("-fx-text-fill: #44ff66;");
               goToScene("Home.fxml","HOME",loginMessageLabel);
           }else{//neu k co user
               loginMessageLabel.setText("failed to login !");
           };
       }catch (Exception e){
           e.printStackTrace();
           e.getCause();
       }

   }

}
