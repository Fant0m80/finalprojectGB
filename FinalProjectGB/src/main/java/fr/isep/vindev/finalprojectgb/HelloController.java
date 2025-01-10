package fr.isep.vindev.finalprojectgb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button Button_Projet;

    @FXML
    private Button Button_Employe;

    @FXML
    protected void onButton_ProjetClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage newstage = new Stage();
        newstage.setTitle("Projet");
        newstage.setScene(scene);

        newstage.show();
    }

    @FXML
    protected void onButton_EmployeClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage newstage = new Stage();
        newstage.setTitle("Employe");
        newstage.setScene(scene);

        newstage.show();
    }
}