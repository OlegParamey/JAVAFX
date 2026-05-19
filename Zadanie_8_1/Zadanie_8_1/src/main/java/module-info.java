module com.example.zadanie_8_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.zadanie_8_1 to javafx.fxml;
    exports com.example.zadanie_8_1;
}