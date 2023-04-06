module thinscript.com {
    requires javafx.controls;
    requires javafx.fxml;

    opens thinscript.com to javafx.fxml;
    exports thinscript.com;
}
