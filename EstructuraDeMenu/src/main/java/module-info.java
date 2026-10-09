module com.lubiasystem.estructurademenu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.lubiasystem.estructurademenu to javafx.fxml;
    exports com.lubiasystem.estructurademenu;

    opens com.lubiasystem.estructurademenu.controller to javafx.fxml;
    exports com.lubiasystem.estructurademenu.controller;

    opens com.lubiasystem.estructurademenu.clases to javafx.fxml;
    exports com.lubiasystem.estructurademenu.clases;
}