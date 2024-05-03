package org.caro.caroclient.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static org.caro.caroclient.controller.Utils.goToScene;

public class PlayAutoController implements Initializable{

    @FXML
    private ImageView avatarUser;

    @FXML
    private TextField chatField;

    @FXML
    private Label userNameLabel;

    @FXML
    private Button backToHomeButton;
    @FXML
    private GridPane gridPane;
    @FXML
    private ScrollPane scrollField;
    @FXML
    private VBox chatContent;

    @FXML
    private Button sendButton;



    public PlayAutoController() {


    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backToHomeButton.setOnAction(actionEvent -> {
            goToScene("Home.fxml","HOME",backToHomeButton);
        });
        for (int row = 0; row < 17; row++) {
            for (int col = 0; col < 17; col++) {
                Button button = new Button();
                button.setPrefSize(30, 30);
                button.setStyle("-fx-background-color : transparent; ");

                String pathX = "/Images/iconX.png";
                String pathO = "/Images/icons_circle.png";
                Image imageIconX = new Image(getClass().getResourceAsStream(pathX));
                Image imageIconO = new Image(getClass().getResourceAsStream(pathO));
                ImageView imageView = new ImageView(imageIconX);
                imageView.setFitHeight(29);
                imageView.setFitWidth(29);
                imageView.setTranslateX(-5);
                imageView.setVisible(false);
                button.setGraphic(imageView);
                button.setOnAction(event -> {
                    if(imageView.isVisible()){
                        imageView.setImage(imageIconO);
                    }else{
                        imageView.setVisible(true);
                    }
// lay vi tri cua button
                    Node source = (Node) event.getSource();
                    Integer colIndex = GridPane.getColumnIndex(source);
                    Integer rowIndex = GridPane.getRowIndex(source);
                    System.out.println("(" + colIndex+","+rowIndex + ")");
                    //fuction de tiep tuc danh O
                });

                gridPane.add(button, col, row);
            }
        }

        chatField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                setSendButton();
                event.consume(); // Ngăn chặn sự kiện Enter từ việc lan truyền đến các thành phần khác
            }
        });

    }

    public void setSendButton(){
        String messages = chatField.getText();
        Label newMessage = new Label();
        newMessage.setText("<You> : "+ messages);
//        newMessage.getStylesheets().add("");
        if(!messages.isEmpty()){
            chatContent.getChildren().add(newMessage);
            chatField.clear();
            scrollField.setVvalue(1.0);
        }
    }
}