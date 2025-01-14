package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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
        int c = 0;
        for (Projet projet : listeProjet) {
            for (int j=0; j<GridPane_listeProjet.getColumnCount(); j++) {
                for (int i = 0; i < GridPane_listeProjet.getRowCount(); i++) {
                    if (isCaseEmpty(GridPane_listeProjet, i, j)) {
                        Label projetLabel = new Label(projet.getNomDuProjet());
                        projetLabel.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5;");
                        GridPane_listeProjet.add(projetLabel, i, j);
                        c+=1;
                        break;
                    }
                }
                if (c == 1){
                    c = 0;
                    break;
                }
            }
        }
    }


    private boolean isCaseEmpty(GridPane grid, int row, int col) {
        for (Node node : grid.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            rowIndex = (rowIndex == null) ? 0 : rowIndex;
            colIndex = (colIndex == null) ? 0 : colIndex;

            if (rowIndex == row && colIndex == col) {
                return false;
            }
        }
        return true;
    }
}
