package fr.isep.vindev.finalprojectgb;

import java.util.ArrayList;
import java.util.Date;

public class Projet {
    private String nomDuProjet;
    private Date deadline;
    private ArrayList listeDesMembres = new ArrayList<Employe>();
    private ArrayList listeDesTaches = new ArrayList<Tache>();
    private double budget;

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
