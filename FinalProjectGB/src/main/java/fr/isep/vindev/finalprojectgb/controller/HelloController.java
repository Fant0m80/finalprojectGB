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
    private ChoiceBox<Employe> ChoiceBox_Employe;

    @FXML
    private ChoiceBox<Projet> ChoiceBox_Projet;

    @FXML
    protected void onButton_ProjetClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add("path/to/styles.css");

        Projet projetSelected = ChoiceBox_Projet.getValue();
        Projet.setNomProjetSelected(projetSelected.getNomDuProjet());

        Stage newstage = new Stage();

        newstage.setTitle("Projet");
        newstage.setScene(scene);

        newstage.show();
    }

    @FXML
    protected void onButton_EmployeClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        EmployeController employeController = fxmlLoader.getController();

        Employe selectedEmploye = ChoiceBox_Employe.getValue();
        if (selectedEmploye != null) {
            employeController.afficherEmploye(selectedEmploye);
        }

        Stage newstage = new Stage();
        newstage.setTitle("Employe");
        newstage.setScene(scene);

        newstage.show();
    }

    @FXML
    protected void onButton_CreerEmployeClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewEmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Employe");
        newstage.setScene(scene);

        newstage.show();
    }
    @FXML
    protected void onButton_CreerProjetClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Projet");
        newstage.setScene(scene);

        newstage.show();
    }

    @FXML
    protected void onChoiceBox_EmployeClick() throws IOException {
        ChoiceBox_Employe.getItems().clear();
        for (int i = 0; i< Employe.tousLesEmployes.size(); i++ ){
            ChoiceBox_Employe.getItems().add(Employe.tousLesEmployes.get(i));
        }
    }
    @FXML
    protected void onChoiceBox_ProjetClick() throws IOException {
        ChoiceBox_Projet.getItems().clear();
        for (int i = 0; i< Projet.tousLesProjets.size(); i++ ){
            ChoiceBox_Projet.getItems().add(Projet.tousLesProjets.get(i));
        }
    }

    @FXML
    protected void onButton_AddEmployeToProjetClick() throws IOException {
        Employe selectedEmploye = ChoiceBox_Employe.getValue();
        Projet selectedProjet = ChoiceBox_Projet.getValue();
        if (selectedEmploye != null && selectedProjet != null) {
            selectedProjet.ajouterMembre(selectedEmploye);
            System.out.println(selectedEmploye + " travaille maintenant sur " + selectedProjet);
        }
    }

}