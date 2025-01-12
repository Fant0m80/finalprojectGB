package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewProjetController {
    @FXML
    private Button Button_CreationProjet;

    @FXML
    private TextField TextField_NomProjet;

    @FXML
    private TextField TextField_BudgetProjet;

    @FXML
    private DatePicker LocalDate_Deadline;

    @FXML
    protected void onButton_CreationProjetClick() throws IOException {
        for (Projet projet : Projet.tousLesProjets){
            if (projet.getNomDuProjet() == TextField_NomProjet.getText()){
                return;
            }
        }
        Projet newProjet = new Projet(TextField_NomProjet.getText(),LocalDate_Deadline.getValue(), Double.parseDouble(TextField_BudgetProjet.getText()));
        Projet.tousLesProjets.add(newProjet);

        Stage stage = (Stage) Button_CreationProjet.getScene().getWindow();
        stage.close();

    }
}
