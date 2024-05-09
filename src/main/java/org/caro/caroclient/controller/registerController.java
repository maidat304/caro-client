package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button ;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;


import java.net.URL ;
import java.sql.*;
import java.util.ResourceBundle;

import static org.caro.caroclient.controller.Utils.goToScene;

public class registerController implements Initializable {
    @FXML
    private Label registerMessageLabel;

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
        if(!userName.getText().isBlank()
        && !password.getText().isBlank() && !rePassword.getText().isBlank()) {
            validateRegister();
        }else {
            registerMessageLabel.setText("Please fill all fields!!");
            registerMessageLabel.setStyle("-fx-text-fill : #ab1f12;");
        }
    }


    public void validateRegister(){
        //mat khau co it nhat 6 chu cai& chu so, pw = repw, userid phai co ca chu so va chu cai

        String passwordText = password.getText();
        String rePasswordText = rePassword.getText();
        registerMessageLabel.setStyle("-fx-text-fill : #ab1f12;");
        if (isUserNameExists(userName.getText())) {
            registerMessageLabel.setText("User Name already exists. Please choose another one.");
            return;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;


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

    private boolean isUserNameExists(String text) {
        DatabaseConnection connectionDB = new DatabaseConnection();
        Connection connection = connectionDB.getConnection();

        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setString(1, text);
            ResultSet result= pStatement.executeQuery();

            if(result.next()){
                if(result.getInt(1) > 0) {
                    connection.close();
                    return true;
                } else {
                    connection.close();
                    return false;
                }
            }else{
                connection.close();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
            return false;
        }
    }

    public void insertUser(){
        DatabaseConnection connetionNow = new DatabaseConnection();
        Connection connectDB = connetionNow.getConnection();

        String userNameText = userName.getText();
        String passwordText = password.getText();
        //String rePasswordText = rePassword.getText();

        String insertString = "INSERT INTO users (username, password) VALUES ('"  + userNameText + "', '" + passwordText + "')";

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

}
