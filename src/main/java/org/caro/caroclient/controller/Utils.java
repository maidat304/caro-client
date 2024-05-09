package org.caro.caroclient.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Utils {
    public static void goToScene(String fxmlFile, String title, Node node) {
        //dong stage hiện tại
        Stage currentStage = (Stage) node.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/org/caro/caroclient/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public static void alertScene(String fxmlFile, String title){
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/org/caro/caroclient/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public static boolean alertConfirm(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        alert.close();
        if(result.get() == ButtonType.OK){
            return true;
        }else return false;
    }

    public static  void alert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().addAll(buttonCancel);
        Optional<ButtonType> result = alert.showAndWait();
        alert.close();
    }
}
