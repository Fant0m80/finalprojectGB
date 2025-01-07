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
    private String role;

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

    public String getRole() {
        return role;
    }


}
