package org.caro.caroclient.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CaroClientApplication extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/demo/Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        scene.getStylesheets().add(getClass().getResource("/com/example/demo/Style.css").toExternalForm());
        stage.setTitle("Login scene");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}