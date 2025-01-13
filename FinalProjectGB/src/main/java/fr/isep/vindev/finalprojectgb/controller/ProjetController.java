package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjetController {

    private int coordonneeX = 50;
    private int coordonneeY = 100;

    @FXML
    private Button Button_AjouterTache;

    @FXML
    private DialogPane Dialog_CreationTache;

    @FXML
    private TextField TextField_CreationTache;

    @FXML
    private TextField TextField_Categorie;

    @FXML
    private DatePicker DatePicker_Deadline;

    @FXML
    private TextField TextField_Priorite;

    @FXML
    private TextArea TextArea_Description;

    @FXML
    private AnchorPane AnchorPane_Parent;

    @FXML
    private Label Label_AffichageProjet;

    @FXML
    public void initialize(){
        Dialog_CreationTache.setVisible(false);
        Stage stage = (Stage) AnchorPane_Parent.getScene().getWindow();
        Label_AffichageProjet.setText(stage.getTitle());
    }

    @FXML
    protected void onButton_AjouterTacheClick() throws IOException{
        TextField_CreationTache.clear();
        TextField_Categorie.clear();
        DatePicker_Deadline.setValue(null); ;
        TextField_Priorite.clear();
        TextArea_Description.clear();

        Dialog_CreationTache.setVisible(true);
        Dialog_CreationTache.toFront();

        Button_AjouterTache.setDisable(false);
    }

    public void ajouterTache(AnchorPane parentPane){
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);

        VBox vbox = new VBox(10);

        Label labelNomTache = new Label(TextField_CreationTache.getText());
        Label labelCategorie = new Label("Catégorie : " + TextField_Categorie.getText() );
        Label labelpriorite = new Label("Priorité : " + TextField_Priorite.getText());
        Label labeldeadline = new Label("Deadline : " + DatePicker_Deadline.getValue().toString());
        Label labelDescription = new Label("Description : " + TextArea_Description.getText());

        Insets decalage = new Insets(10,0,0,0);
        VBox.setMargin(labelCategorie,decalage);
        VBox.setMargin(labelpriorite,decalage);
        VBox.setMargin(labeldeadline,decalage);
        VBox.setMargin(labelDescription,decalage);

        vbox.getChildren().addAll(labelCategorie, labelpriorite, labeldeadline,labelDescription);

        StackPane paneHaut = new StackPane(labelNomTache);
        StackPane paneBas = new StackPane(vbox);

        paneHaut.setStyle("-fx-background-color: lightblue;");
        paneBas.setStyle("-fx-background-color: lightblue;");

        splitPane.getItems().addAll(paneHaut, paneBas);
        splitPane.setDividerPositions(0.3);

        splitPane.setLayoutX(coordonneeX);
        splitPane.setLayoutY(coordonneeY);

        coordonneeY += 275;

        splitPane.setPrefSize(250, 250);

        parentPane.getChildren().add(splitPane);
    }

    @FXML
    protected void onButton_CreationTacheClick(){
        Dialog_CreationTache.setVisible(false);
        Button_AjouterTache.setDisable(true);

        

        ajouterTache(AnchorPane_Parent);
    }
}
