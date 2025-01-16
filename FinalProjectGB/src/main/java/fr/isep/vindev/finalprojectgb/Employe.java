package fr.isep.vindev.finalprojectgb;

import java.util.ArrayList;
import java.util.UUID;

public class Employe {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private ArrayList<Projet> listeProjet = new ArrayList<Projet>();
    private String[] role = new String[2];
    private ArrayList<Projet> historique = new ArrayList<Projet>();
    public ArrayList<Tache> listeTache = new ArrayList<Tache>();

    public static ArrayList<Employe> tousLesEmployes = new ArrayList<Employe>();

    public Employe(String nom, String prenom, String email, String telephone) {
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public ArrayList getListeProjet() {
        return listeProjet;
    }

    public ArrayList<Tache> getListeTache() {
        return listeTache;
    }

    public String getRole(int n) {
        return role[n];
    }

    public void setRole(String role) {
        this.role[1] = role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setListeProjet(ArrayList listeProjet) {
        this.listeProjet = listeProjet;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public ArrayList getHistorique() {
        return historique;
    }

    public void setHistorique(ArrayList historique) {
        this.historique = historique;
    }

    private void addHistorique(Projet projet) {
        for (int i = 0; i < projet.getListeDesMembres().size(); i++) {
            if (this == projet.getListeDesMembres().get(i)){
                historique.add(projet);
                break;
            }
        }
    }

    public void attribuerProjet(Projet projet) {
        this.listeProjet.add(projet);
    }

    public void supprimerProjet(Projet projet) {
        this.listeProjet.remove(projet);
        this.addHistorique(projet);
    }

    public void supprimerEmploye(){
        for (Tache tache : this.listeTache) {
            tache.supprimerMembre(this);
        }
        for (Projet projet : this.listeProjet) {
            projet.supprimerMembre(this);
        }
        tousLesEmployes.remove(this);
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
