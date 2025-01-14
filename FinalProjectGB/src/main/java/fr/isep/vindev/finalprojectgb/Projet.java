package fr.isep.vindev.finalprojectgb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Projet {
    private String nomDuProjet;
    private LocalDate deadline;
    private ArrayList<Employe> listeDesMembres = new ArrayList<Employe>();
    private ArrayList<Tache> listeDesTaches = new ArrayList<Tache>();
    private double budget;

    public static ArrayList<Projet> tousLesProjets = new ArrayList<Projet>();
    public static Projet projetSelectionnee = new Projet(null, null, 0);
    public static boolean creation = true;

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

    public static void supprimerProjet(Projet projetasupp){
        tousLesProjets.removeIf(projet ->
                projet.getNomDuProjet().equals(projetasupp.getNomDuProjet())
        );
    }

    public static void projetParNom(String nomDuProjet){
        for (Projet projet : tousLesProjets){
            if (projet.getNomDuProjet() == nomDuProjet){
                projetSelectionnee.setNomDuProjet(projet.getNomDuProjet());
                projetSelectionnee.setBudget(projet.getBudget());
                projetSelectionnee.setDeadline(projet.getDeadline());
            }
        }
    }

    public static void reinitialiserProjetSelectionnee(Projet projetselec){
        projetselec.setNomDuProjet(null);
        projetselec.setBudget(0);
        projetselec.setDeadline(null);
    }

    public static Projet trouverProjetAvecProjetSelec(Projet projetSelectionnee){
        for (Projet projet : tousLesProjets){
            if (projet.getNomDuProjet() == projetSelectionnee.getNomDuProjet()){
                return projet;
            }
        } return projetSelectionnee;
    }

    @Override
    public String toString() {
        return nomDuProjet;
    }
}
