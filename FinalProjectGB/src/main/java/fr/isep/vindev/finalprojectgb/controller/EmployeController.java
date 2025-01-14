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

    /*
    private void afficherProjets(ArrayList<Projet> listeProjet) {
        GridPane_listeProjet.getChildren().clear();
        int c = 0;
        for (Projet projet : listeProjet) {
            /*
            if (GridPane_listeProjet.getChildren().size() == GridPane_listeProjet.getRowCount()*GridPane_listeProjet.getColumnCount()) {
                GridPane_listeProjet.getRowConstraints().add(new RowConstraints());
            }


            for (int i = 0; i<GridPane_listeProjet.getRowCount(); i++) {
                for (int j = 0; j < GridPane_listeProjet.getColumnCount(); j++) {
                    if (isCaseEmpty(GridPane_listeProjet, j, i)) {
                        Label projetLabel = new Label(projet.getNomDuProjet());
                        projetLabel.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5;");
                        GridPane_listeProjet.add(projetLabel, j, i);
                        GridPane.setColumnIndex(projetLabel, j);
                        GridPane.setRowIndex(projetLabel, i);
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
    */
    private void afficherProjets(ArrayList<Projet> listeProjet) {
        // Vider la grille avant d'ajouter les nouveaux projets
        GridPane_listeProjet.getChildren().clear();

        int rows = GridPane_listeProjet.getRowCount(); // Nombre actuel de lignes
        int cols = GridPane_listeProjet.getColumnCount(); // Nombre fixe de colonnes
        int totalCells = rows * cols; // Nombre total de cellules
        int currentCell = 0; // Indice de la cellule en cours

        for (Projet projet : listeProjet) {
            // Si toutes les cases actuelles sont remplies, ajouter une nouvelle ligne
            if (currentCell >= totalCells) {
                GridPane_listeProjet.getRowConstraints().add(new RowConstraints());
                rows++;
                totalCells = rows * cols; // Recalculer le nombre total de cellules
            }

            // Calculer la position de la cellule
            int row = currentCell / cols; // Ligne correspondante
            int col = currentCell % cols; // Colonne correspondante

            // Ajouter le projet à la cellule calculée
            Label projetLabel = new Label(projet.getNomDuProjet());
            projetLabel.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5;");
            GridPane_listeProjet.add(projetLabel, col, row);

            // Passer à la cellule suivante
            currentCell++;
        }
    }



    private boolean isCaseEmpty(GridPane grid, int row, int col) {
        for (Node node : grid.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            System.out.println(colIndex + " et " + rowIndex);

            rowIndex = (rowIndex == null) ? 0 : rowIndex;
            colIndex = (colIndex == null) ? 0 : colIndex;

            if (rowIndex == row && colIndex == col) {
                return false;
            }
        }
        return true;
    }
}
