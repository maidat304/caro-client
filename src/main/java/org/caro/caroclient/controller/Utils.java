package org.caro.caroclient.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {
    public static void goToScene(String fxmlFile, String title, Node node) {
        //dong stage hiện tại
        Stage currentStage = (Stage) node.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/com/example/demo/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alertScene(String fxmlFile, String title){
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/com/example/demo/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
