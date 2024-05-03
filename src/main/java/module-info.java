module org.caro.caroclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.caro.caroclient to javafx.fxml;
    exports org.caro.caroclient;
}