package fr.isep.vindev.finalprojectgb;

import java.util.ArrayList;
import java.util.Date;

public class Tache {
    private String nomTache;
    private Date deadline;
    private String categorie;
    private int priorite;
    private String description;
    private ArrayList listeMembres = new ArrayList<Employe>();

    public String getNomTache() {
        return nomTache;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getPriorite() {
        return priorite;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList getListeMembres() {
        return listeMembres;
    }
}
