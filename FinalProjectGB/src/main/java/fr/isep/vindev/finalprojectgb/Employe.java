package fr.isep.vindev.finalprojectgb;

import java.util.ArrayList;
import java.util.UUID;

public class Employe {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private int telephone;
    private ArrayList listeProjet = new ArrayList<Projet>();
    private String[] role = new String[2];
    private ArrayList historique = new ArrayList<Projet>();

    public static ArrayList tousLesEmployes = new ArrayList<Employe>();

    public Employe(String nom, String prenom, String email, int telephone) {
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

    public int getTelephone() {
        return telephone;
    }

    public ArrayList getListeProjet() {
        return listeProjet;
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

    public void setTelephone(int telephone) {
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
}
