package fr.isep.vindev.finalprojectgb.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

import java.io.IOException;

public class ProjetController {

    @FXML
    private Button Button_AjouterTache;

    @FXML
    private DialogPane Dialog_CreationTache;

    @FXML
    public void initialize(){
        Dialog_CreationTache.setVisible(false);
    }

    @FXML
    protected void onButton_AjouterTacheClick() throws IOException{
        Dialog_CreationTache.setVisible(true);
    }

    @FXML
    protected void onButton_CreationTacheClick(){

    }
}
