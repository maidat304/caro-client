package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button ;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;


import java.net.URL ;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static org.caro.caroclient.controller.Utils.goToScene;

public class registerController implements Initializable {
    @FXML
    private Label registerMessageLabel;
    @FXML
    private TextField userID ;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField rePassword;
    @FXML
    private Button sendButton;
    @FXML
    private ImageView avataImage;
    @FXML
    private Button uploadButton;

    @FXML
    private ImageView uploadImageView;

    @FXML
    private Button backToLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backToLogin.setOnAction(actionEvent -> goToScene("Login.fxml","Login",backToLogin));
    }

    public void sendButtonAction(){
        if(!userID.getText().isBlank() && !userName.getText().isBlank()
        && !password.getText().isBlank() && !rePassword.getText().isBlank()) {
            validateRegister();
        }else {
            registerMessageLabel.setText("Please fill all fields!!");
            registerMessageLabel.setStyle("-fx-text-fill : #ab1f12;");
        }
    }


    public void validateRegister(){
        //mat khau co it nhat 6 chu cai& chu so, pw = repw, userid phai co ca chu so va chu cai
        String userIDText = userID.getText();
        String passwordText = password.getText();
        String rePasswordText = rePassword.getText();
        registerMessageLabel.setStyle("-fx-text-fill : #ab1f12;");

        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char c : userIDText.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        if (!hasLetter || !hasDigit) {
            registerMessageLabel.setText("User ID must contain at least one letter and one digit.");
            return;
        }

        if (passwordText.length() < 6) {
            registerMessageLabel.setText("Password must be at least 6 characters long.");
            return;
        }

         hasLetter = false;
         hasDigit = false;
        for (char c : passwordText.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        if (!hasLetter || !hasDigit) {
            registerMessageLabel.setText("Password must contain at least one letter and one digit.");
            return;
        }


        if (!passwordText.equals(rePasswordText)) {
            registerMessageLabel.setText("Passwords do not match.");
            return;
        }


        registerMessageLabel.setText("Registration successful!");
        registerMessageLabel.setStyle("-fx-text-fill: #44ff66 ;");
        insertUser();
        goToScene("Home.fxml","HOME",registerMessageLabel);
    }

    public void insertUser(){
        DatabaseConnection connetionNow = new DatabaseConnection();
        Connection connectDB = connetionNow.getConnection();

        String userIDText = userID.getText();
        String userNameText = userName.getText();
        String passwordText = password.getText();
        //String rePasswordText = rePassword.getText();

        String insertString = "INSERT INTO users (user_id, username, password) VALUES ('" +
                userIDText + "', '" + userNameText + "', '" + passwordText + "')";

        try {
            Statement statement = connectDB.createStatement();
            int rowsAffected = statement.executeUpdate(insertString);

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully!");
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }finally {
            try {
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }


    }  

//    public void goToHome(){
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
//        try {
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//
//            stage.setTitle("HOME");
//            stage.setScene(scene);
//            stage.show();
//
//            Stage currentStage = (Stage) registerMessageLabel.getScene().getWindow();
//            currentStage.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
