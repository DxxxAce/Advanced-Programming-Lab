module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.lab6 to javafx.fxml;
    exports com.lab6;
}