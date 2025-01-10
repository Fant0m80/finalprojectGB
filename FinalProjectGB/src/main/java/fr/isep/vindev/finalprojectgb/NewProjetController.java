package fr.isep.vindev.finalprojectgb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

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

        Projet newProjet = new Projet(TextField_NomProjet.getText(),LocalDate_Deadline.getValue(), Double.parseDouble(TextField_BudgetProjet.getText()));
        tousLesProjets.add(newProjet);
    }
}
