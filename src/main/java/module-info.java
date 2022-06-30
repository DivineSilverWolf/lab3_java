module sapper.org.example {
    requires javafx.controls;
    requires javafx.fxml;


    exports sapper.controllers;
    opens sapper.controllers to javafx.fxml;
    exports sapper.core;
    opens sapper.core to javafx.fxml;

}
