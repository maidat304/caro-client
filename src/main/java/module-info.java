module org.caro.caroclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.caro.caroclient to javafx.fxml;
    exports org.caro.caroclient.controller;
    exports org.caro.caroclient.model;
    opens org.caro.caroclient.controller to javafx.fxml;
}