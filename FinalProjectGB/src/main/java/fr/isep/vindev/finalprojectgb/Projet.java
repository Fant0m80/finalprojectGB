package fr.isep.vindev.finalprojectgb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Projet {
    private String nomDuProjet;
    private LocalDate deadline;
    private ArrayList<Employe> listeDesMembres = new ArrayList<Employe>();
    private ArrayList<Tache> listeDesTaches = new ArrayList<Tache>();
    private double budget;

    public static ArrayList<Projet> tousLesProjets = new ArrayList<Projet>();
    public static String nomProjetSelected = new String();

    public Projet(String nomDuProjet, LocalDate deadline, double budget) {
        this.nomDuProjet = nomDuProjet;
        this.deadline = deadline;
        this.budget = budget;
    }

    public void attribuerRole(Employe employe, String role) {
        if (this.nomDuProjet == employe.getRole(0)){
            employe.setRole(role);
        }
    }

    public void supprimerRole(Employe employe) {
        if (this.nomDuProjet == employe.getRole(0)){
            employe.setRole("");
        }
    }

    public void ajouterMembre(Employe employe){
        this.listeDesMembres.add(employe);
        employe.attribuerProjet(this);
    }

    public void supprimerMembre(Employe employe){
        for (int i = 0; i < this.getListeDesMembres().size(); i++) {
            if (employe == this.getListeDesMembres().get(i)){
                this.listeDesMembres.remove(employe);
                employe.supprimerProjet(this);
                System.out.println("Le membre '" + employe.getNom() + " " + employe.getPrenom() + "a bien été enlevé du projet !");
                break;
            }
        }
    }

    public void setNomDuProjet(String nomDuProjet) {
        this.nomDuProjet = nomDuProjet;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNomDuProjet(){
        return nomDuProjet;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public ArrayList getListeDesMembres() {
        return listeDesMembres;
    }

    public ArrayList getListeDesTaches() {
        return listeDesTaches;
    }

    public double getBudget() {
        return budget;
    }

    public static String getNomProjetSelected() {
        return nomProjetSelected;
    }

    public static void setNomProjetSelected(String nomProjetSelected) {
        Projet.nomProjetSelected = nomProjetSelected;
    }

    @Override
    public String toString() {
        return nomDuProjet;
    }
}
