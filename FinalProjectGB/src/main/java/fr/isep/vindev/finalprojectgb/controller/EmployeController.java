package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private HBox HBox_listeProjet;

    public void afficherEmploye(Employe selectedEmploye) {
        nom.setText(selectedEmploye.getNom());
        prenom.setText(selectedEmploye.getPrenom());
        email.setText(selectedEmploye.getEmail());
        tel.setText(selectedEmploye.getTelephone());

        afficherProjets(selectedEmploye.getListeProjet());

    }

    private void afficherProjets(ArrayList<Projet> listeProjet) {
        HBox_listeProjet.getChildren().clear();

        for (Projet projet : listeProjet) {
            Label projetLabel = new Label(projet.getNomDuProjet());
            projetLabel.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5;");
            HBox_listeProjet.getChildren().add(projetLabel);
        }
    }
}
