package fr.isep.vindev.finalprojectgb.controller;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ProjetController {

    @FXML
    private Button Button_AjouterTache;

    @FXML
    private DialogPane Dialog_CreationTache;

    @FXML
    private TextField TextField_NomTache;

    @FXML
    private TextField TextField_Categorie;

    @FXML
    private DatePicker DatePicker_Deadline;

    @FXML
    private TextField TextField_Priorite;

    @FXML
    private TextArea TextArea_Description;

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
        Dialog_CreationTache.setVisible(false);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);


        Label labelNomTache = new Label(TextField_NomTache.getText());
        Label labelCategorie = new Label(TextField_Categorie.getText()+" :");
        Label labelpriorite = new Label("Priorité : " + TextField_Priorite.getText());
        Label labeldeadline = new Label("Deadline : " + DatePicker_Deadline.getValue().toString());

        StackPane paneHaut = new StackPane(labelNomTache);
        StackPane paneBas = new StackPane(labelCategorie, labelpriorite, labeldeadline);

        paneHaut.setStyle("-fx-background-color: lightblue;");
        paneBas.setStyle("-fx-background-color: lightblue;");

        splitPane.setLayoutX(50);
        splitPane.setLayoutY(100);
        splitPane.setPrefSize(400, 200);

        splitPane.getItems().addAll(paneHaut, paneBas);
        splitPane.setDividerPositions(0.3);
    }
}
