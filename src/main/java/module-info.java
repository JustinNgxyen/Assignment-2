module org.example.wordle {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.wordle to javafx.fxml;
    exports org.example.wordle;
    exports org.example.wordle.controller;
    opens org.example.wordle.controller to javafx.fxml;
}
