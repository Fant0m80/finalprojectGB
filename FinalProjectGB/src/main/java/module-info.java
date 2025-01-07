module fr.isep.vindev.finalprojectgb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens fr.isep.vindev.finalprojectgb to javafx.fxml;
    exports fr.isep.vindev.finalprojectgb;
}