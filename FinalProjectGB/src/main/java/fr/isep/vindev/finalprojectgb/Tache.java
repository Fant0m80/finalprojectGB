package fr.isep.vindev.finalprojectgb;

import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Tache {
    private String nomTache;
    private Projet projet;
    private LocalDate deadline;
    private String categorie;
    private int priorite;
    private String description;
    private ArrayList listeMembres = new ArrayList<Employe>();

    public static Tache tacheSelectionnee = new Tache(null,Projet.projetSelectionnee,null,null,0,null);

    public Tache(String nomTache, Projet projet, LocalDate deadline, String categorie, int priorite, String description) {
        this.nomTache = nomTache;
        this.projet = projet;
        this.deadline = deadline;
        this.categorie = categorie;
        this.priorite = priorite;
        this.description = description;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomTache() {
        return nomTache;
    }

    public LocalDate getDeadline() {
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

    public void ajouterMembre(Employe employe) {
        for (int i = 0; i < this.projet.getListeDesMembres().size(); i++) {
            if (this.projet.getListeDesMembres().get(i).equals(employe)) {
                this.listeMembres.add(employe);
            }
        }
    }

    public void supprimerMembre(Employe employe) {
        for (int i = 0; i < this.listeMembres.size(); i++) {
            if (this.listeMembres.get(i).equals(employe)) {
                this.listeMembres.remove(employe);
            }
        }
    }

    public static void supprimerTache(String nomTache, Projet projet){
        for (Tache tache : projet.getListeDesTaches()){
            if (tache.getNomTache() == nomTache){
                projet.getListeDesTaches().remove(tache);
            }
        }
    }
}
