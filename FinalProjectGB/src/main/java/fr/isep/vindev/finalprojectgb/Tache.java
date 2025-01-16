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
        this.listeMembres = new ArrayList<Employe>();
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

    public Projet getProjet() {
        return projet;
    }

    public ArrayList<Employe> getListeMembres(){
        return listeMembres;
    }

    public void ajouterMembre(Employe employe) {
        for (int i = 0; i < this.projet.getListeDesMembres().size(); i++) {
            if (this.projet.getListeDesMembres().get(i).equals(employe)) {
                this.listeMembres.add(employe);
                employe.listeTache.add(this);
            }
        }
    }

    public void supprimerMembre(Employe employe) {
        for (int i = 0; i < this.listeMembres.size(); i++) {
            if (this.listeMembres.get(i).equals(employe)) {
                this.listeMembres.remove(employe);
                employe.listeTache.remove(this);
            }
        }
    }

    public static void supprimerTache(String nomTache, Projet projet){
        for (Tache tache : projet.getListeDesTaches()){
            if (tache.getNomTache() == nomTache){
                for (Employe employe : tache.getListeMembres()) {
                    for (Tache tacheEmploye : employe.listeTache) {
                        if (tacheEmploye.getNomTache() == nomTache) {
                            employe.listeTache.remove(tacheEmploye);
                        }
                    }
                }
            }
            projet.getListeDesTaches().remove(tache);
        }
    }
}

