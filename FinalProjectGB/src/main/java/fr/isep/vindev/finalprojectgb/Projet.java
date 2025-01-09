package fr.isep.vindev.finalprojectgb;

import java.util.ArrayList;
import java.util.Date;

public class Projet {
    private String nomDuProjet;
    private Date deadline;
    private ArrayList listeDesMembres = new ArrayList<Employe>();
    private ArrayList listeDesTaches = new ArrayList<Tache>();
    private double budget;

    public Projet(String nomDuProjet, Date deadline, double budget) {
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

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNomDuProjet(){
        return nomDuProjet;
    }

    public Date getDeadline() {
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
}
