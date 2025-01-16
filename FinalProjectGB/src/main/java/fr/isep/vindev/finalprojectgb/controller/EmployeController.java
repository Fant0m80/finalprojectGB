package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class EmployeController {
    @FXML
    private Employe selectedEmploye;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label email;

    @FXML
    private Label tel;

    @FXML
    private GridPane GridPane_listeProjet;

    public void afficherEmploye(Employe selectedEmploye) {
        nom.setText(selectedEmploye.getNom());
        prenom.setText(selectedEmploye.getPrenom());
        email.setText(selectedEmploye.getEmail());
        tel.setText(selectedEmploye.getTelephone());

        afficherProjets(selectedEmploye.getListeProjet());

    }

    private void afficherProjets(ArrayList<Projet> listeProjet) {
        GridPane_listeProjet.getChildren().clear();

        int rows = GridPane_listeProjet.getRowCount();
        int cols = GridPane_listeProjet.getColumnCount();
        int totalCells = rows * cols;
        int currentCell = 0;

        for (Projet projet : listeProjet) {
            if (currentCell >= totalCells) {
                GridPane_listeProjet.getRowConstraints().add(new RowConstraints());
                rows++;
                totalCells = rows * cols;
            }

            int row = currentCell / cols;
            int col = currentCell % cols;

            Label projetLabel = new Label(projet.getNomDuProjet());
            projetLabel.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5; -fx-alignment: center;");
            GridPane_listeProjet.add(projetLabel, col, row);
            currentCell++;
        }
    }
}
