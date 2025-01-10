package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import fr.isep.vindev.finalprojectgb.HelloApplication;
import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button Button_Projet;

    @FXML
    private Button Button_Employe;

    @FXML
    private Button Button_CreerEmploye;

    @FXML
    private ChoiceBox ChoiceBox_Employe;

    @FXML
    private ChoiceBox ChoiceBox_Projet;

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

    @FXML
    protected void onButton_CreerEmployeClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewEmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Employe");
        newstage.setScene(scene);

        newstage.show();
    }
    @FXML
    protected void onButton_CreerProjetClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Projet");
        newstage.setScene(scene);

        newstage.show();
    }

    @FXML
    protected void onChoiceBox_EmployeClick() throws IOException {
        ChoiceBox_Employe.getItems().clear();
        for (int i = 0; i< Employe.tousLesEmployes.size(); i++ ){
            ChoiceBox_Employe.getItems().add(Employe.tousLesEmployes.get(i).getNom());
        }
    }
    @FXML
    protected void onChoiceBox_ProjetClick() throws IOException {
        ChoiceBox_Projet.getItems().clear();
        for (int i = 0; i< Projet.tousLesProjets.size(); i++ ){
            ChoiceBox_Projet.getItems().add(Projet.tousLesProjets.get(i).getNomDuProjet());
        }
    }

}