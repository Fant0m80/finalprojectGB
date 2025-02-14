package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import fr.isep.vindev.finalprojectgb.HelloApplication;
import fr.isep.vindev.finalprojectgb.Projet;
import fr.isep.vindev.finalprojectgb.Tache;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Button Button_Projet;

    @FXML
    private Button Button_Employe;

    @FXML
    private Button Button_CreerEmploye;

    @FXML
    private Button Button_SupprimerProjet;

    @FXML
    private Button Button_ModifierProjet;

    @FXML
    private Label Label_Erreur;

    @FXML
    private ChoiceBox<Employe> ChoiceBox_Employe;

    @FXML
    private ChoiceBox<Projet> ChoiceBox_Projet;

    @FXML
    public void initialize(){
        Label_Erreur.setVisible(false);
    }

    @FXML
    protected void onButton_ProjetClick() throws IOException {
        if (ChoiceBox_Projet.getValue() != null){
            Projet.projetParNom(ChoiceBox_Projet.getValue().getNomDuProjet());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProjetApp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);


            Stage newstage = new Stage();

            newstage.setTitle("Projet : " + ChoiceBox_Projet.getValue().getNomDuProjet() );
            newstage.setScene(scene);

            newstage.show();
        } else{
            Label_Erreur.setVisible(true);
        }

    }

    @FXML
    protected void onButton_EmployeClick() throws IOException {
        if (ChoiceBox_Employe.getValue() != null){
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
            Label_Erreur.setVisible(false);
        } else{
            Label_Erreur.setVisible(true);
        }
    }


    @FXML
    protected void onButton_CreerEmployeClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewEmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        NewEmployeController newEmployeController = fxmlLoader.getController();
        newEmployeController.Button_CreateEmploye.setText("Creer");

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Employe");
        newstage.setScene(scene);

        newstage.show();

        Label_Erreur.setVisible(false);
    }
    @FXML
    protected void onButton_CreerProjetClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage newstage = new Stage();
        newstage.setTitle("Création d'un Projet");
        newstage.setScene(scene);

        newstage.show();

        Label_Erreur.setVisible(false);
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
            Label_Erreur.setVisible(false);
        } else {
            Label_Erreur.setVisible(true);
        }
    }

    @FXML
    protected void onButton_SupprimerProjetClick() throws IOException{
        if (ChoiceBox_Projet.getValue() != null){
            Projet.supprimerProjet(ChoiceBox_Projet.getValue());
            ChoiceBox_Projet.setValue(null);
        }
    }

    @FXML
    protected void onButton_ModifierProjetClick() throws IOException{
        Projet.projetParNom(ChoiceBox_Projet.getValue().getNomDuProjet());
        Projet.creation = false;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage newstage = new Stage();
        newstage.setTitle("Modification d'un Projet");
        newstage.setScene(scene);

        newstage.show();

        ChoiceBox_Projet.getItems().clear();
        Label_Erreur.setVisible(false);
    }

    @FXML
    protected void onButton_SupprimerEmployeClick() throws IOException{
        if (ChoiceBox_Employe.getValue() != null){
            ChoiceBox_Employe.getValue().supprimerEmploye();
            ChoiceBox_Employe.setValue(null);
        }
    }

    @FXML
    protected void onButton_ModifierEmployeClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NewEmployeApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        NewEmployeController newEmployeController = fxmlLoader.getController();

        newEmployeController.TextField_Name.setText(ChoiceBox_Employe.getValue().getNom());
        newEmployeController.TextField_Firstname.setText(ChoiceBox_Employe.getValue().getPrenom());
        newEmployeController.TextField_Email.setText(ChoiceBox_Employe.getValue().getEmail());
        newEmployeController.TextField_Tel.setText(ChoiceBox_Employe.getValue().getTelephone());
        newEmployeController.Button_CreateEmploye.setText("Modifier");

        newEmployeController.selectedEmploye = ChoiceBox_Employe.getValue();

        Stage newstage = new Stage();
        newstage.setTitle("Modification d'un Employe");
        newstage.setScene(scene);

        newstage.show();

        ChoiceBox_Employe.getItems().clear();
        Label_Erreur.setVisible(false);
    }

    @FXML
    protected void onButton_CalendarViewClick() throws IOException {
        if (ChoiceBox_Employe.getValue() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CalendarApp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);

            Employe selectedEmploye = ChoiceBox_Employe.getValue();
            if (selectedEmploye != null) {
                ArrayList<Projet> listeProjets = selectedEmploye.getListeProjet();
                CalendarController calendarController = fxmlLoader.getController();
                calendarController.setProjets(listeProjets);
                ArrayList<Tache> listeTaches = selectedEmploye.getListeTache();
                calendarController.setTaches(listeTaches);
            }

            Stage newstage = new Stage();
            newstage.setTitle("Calendrier");
            newstage.setScene(scene);

            newstage.show();

            Label_Erreur.setVisible(false);
        }
        else{
            Label_Erreur.setVisible(true);
        }
    }


}