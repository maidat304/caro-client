package org.caro.caroclient.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CaroClientApplication extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CaroClientApplication.class.getResource("/org/caro/caroclient/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setTitle("Login scene");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
