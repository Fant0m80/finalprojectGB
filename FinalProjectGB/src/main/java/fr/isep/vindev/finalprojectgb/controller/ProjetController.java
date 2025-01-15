package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Projet;
import fr.isep.vindev.finalprojectgb.Tache;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProjetController {

    private int coordonneeX = 35;
    private int coordonneeY = 70;
    private Map<String, SplitPane> dictTacheToSplitPane = new HashMap<>();
    private double oldX;
    private double oldY;
    private String nomTacheselec;

    @FXML
    private Button Button_AjouterTache;

    @FXML
    private Button Button_ModifierTache;

    @FXML
    private Button Button_CreationTache;

    @FXML
    private ScrollPane ScrollPane_Parent;

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
    private Label Label_Budget;

    @FXML
    private Label Label_Deadline;

    @FXML
    public void initialize(){
        Dialog_CreationTache.setVisible(false);
        Label_AffichageProjet.setText(Projet.projetSelectionnee.getNomDuProjet());
        Label_Budget.setText("Budget : " + Double.toString(Projet.projetSelectionnee.getBudget()));
        Label_Deadline.setText("Date butoir : " + Projet.projetSelectionnee.getDeadline().toString());
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

        Button_AjouterTache.setDisable(true);
        Button_CreationTache.toFront();
        Button_CreationTache.setDisable(false);
        Button_ModifierTache.setVisible(false);
    }

    public void ajouterTache(AnchorPane parentPane){
        Button_AjouterTache.setDisable(false);

        //Création splitPane avec ses infos
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
        splitPane.setDividerPositions(0.2);

        splitPane.setLayoutX(coordonneeX);
        splitPane.setLayoutY(coordonneeY);

        coordonneeX += 225;

        splitPane.setPrefSize(200, 250);
        if (!parentPane.getChildren().contains(splitPane)) {
            parentPane.getChildren().add(splitPane);
        }

        //Création ContextMenu
        ContextMenu contextMenu = new ContextMenu();

        MenuItem modifier = new MenuItem("Modifier");
        MenuItem supprimer = new MenuItem("Supprimer");
        contextMenu.getItems().addAll(modifier,supprimer);

        modifier.setOnAction(event ->{
            for (Projet projet : Projet.tousLesProjets) {
                if (Projet.projetSelectionnee.getNomDuProjet() == projet.getNomDuProjet()) {
                    StackPane paneHaut2 = (StackPane) splitPane.getItems().get(0);

                    Label labelNomTache2 = (Label) paneHaut2.getChildren().get(0);
                    nomTacheselec = labelNomTache2.getText();
                    for (Tache tache : projet.getListeDesTaches()){
                        if (tache.getNomTache() == nomTacheselec){
                            Projet.tacheParNom(nomTacheselec,projet.getNomDuProjet());
                        }
                    }

                    Tache.supprimerTache(labelNomTache2.getText(), projet);
                    Projet.projetSelectionnee.getListeDesTaches().remove(Tache.tacheSelectionnee);

                    AnchorPane_Parent.getChildren().remove(splitPane);
                    dictTacheToSplitPane.remove(Tache.tacheSelectionnee.getNomTache());


                    Button_CreationTache.setVisible(false);

                    TextField_CreationTache.clear();
                    TextField_Categorie.clear();
                    DatePicker_Deadline.setValue(null);
                    ;
                    TextField_Priorite.clear();
                    TextArea_Description.clear();

                    Dialog_CreationTache.setVisible(true);
                    Dialog_CreationTache.toFront();

                    Button_AjouterTache.setDisable(false);
                }
            }
        });
        supprimer.setOnAction(event ->{
            for (Projet projet : Projet.tousLesProjets){
                if (Projet.projetSelectionnee.getNomDuProjet() == projet.getNomDuProjet()){
                    StackPane paneHaut2 = (StackPane) splitPane.getItems().get(0);

                    Label labelNomTache2 = (Label) paneHaut2.getChildren().get(0);
                    nomTacheselec = labelNomTache2.getText();
                    for (Tache tache : projet.getListeDesTaches()){
                        if (tache.getNomTache() == nomTacheselec){
                            Projet.tacheParNom(nomTacheselec,projet.getNomDuProjet());
                        }
                    }

                    Tache.supprimerTache(labelNomTache2.getText(), projet);
                    Projet.projetSelectionnee.getListeDesTaches().remove(Tache.tacheSelectionnee);
                    AnchorPane_Parent.getChildren().remove(splitPane);
                    dictTacheToSplitPane.remove(Tache.tacheSelectionnee.getNomTache());
                }
            }
        });

        splitPane.setOnMouseClicked(event ->{
            if (event.getButton() == MouseButton.SECONDARY){
                oldX = splitPane.localToScene(0, 0).getX();
                oldY = splitPane.localToScene(0, 0).getY();
                System.out.println("Le SplitPane est à : (" + oldX + ", " + oldY + ")");
                contextMenu.show(splitPane, event.getScreenX(), event.getScreenY());
            }
        });

        dictTacheToSplitPane.put(TextField_CreationTache.getText(), splitPane);
        if (!parentPane.getChildren().contains(splitPane)) {
            parentPane.getChildren().add(splitPane);
        }
    }

    @FXML
    protected void onButton_CreationTacheClick(){
        for (Projet projet : Projet.tousLesProjets){
            if (projet.getNomDuProjet() == Projet.projetSelectionnee.getNomDuProjet()){
                Tache newTache = new Tache(TextField_CreationTache.getText(), projet,
                        DatePicker_Deadline.getValue(), TextField_Categorie.getText(),Integer.parseInt(TextField_Priorite.getText()),
                        TextArea_Description.getText());
                projet.getListeDesTaches().add(newTache);
                Projet.projetSelectionnee.getListeDesTaches().add(newTache);
            }
        }
        Dialog_CreationTache.setVisible(false);
        Button_AjouterTache.setDisable(false);
        Button_ModifierTache.setVisible(true);

        ajouterTache(AnchorPane_Parent);

    }

    @FXML
    protected void onButton_ModifierTacheClick(){
        for (Projet projet : Projet.tousLesProjets ){
            if (projet.getNomDuProjet() == Projet.projetSelectionnee.getNomDuProjet()) {
                AnchorPane parent = (AnchorPane) Button_AjouterTache.getParent();

                creationSplitPane(TextField_CreationTache.getText(), TextField_Categorie.getText(),
                        DatePicker_Deadline.getValue(),TextField_Priorite.getText(), TextArea_Description.getText(),
                        oldX,oldY,parent);
                String nomT = Tache.tacheSelectionnee.getNomTache();
                LocalDate dateT = Tache.tacheSelectionnee.getDeadline();
                String descripT = Tache.tacheSelectionnee.getDescription();
                int prioT = Tache.tacheSelectionnee.getPriorite();
                String categoT = Tache.tacheSelectionnee.getCategorie();

                if (TextField_CreationTache.getText( )!= null){
                    nomT = TextField_CreationTache.getText();
                } if (DatePicker_Deadline.getValue() != null){
                    dateT = DatePicker_Deadline.getValue();
                } if (TextField_Categorie.getText() != null){
                    categoT = TextField_Categorie.getText();
                } if (TextField_Priorite.getText() != null){
                    prioT = Integer.parseInt(TextField_Priorite.getText());
                } if (TextField_Categorie.getText() != null){
                    categoT = TextField_Categorie.getText();
                }
                creationSplitPane(nomT,categoT,dateT,String.valueOf(prioT),descripT,
                        oldX,oldY,parent);
                Tache newTache = new Tache(nomT,projet,dateT,categoT,prioT,descripT);

                projet.getListeDesTaches().add(newTache);
                Projet.projetSelectionnee.getListeDesTaches().add(newTache);
            }
        }
        Button_CreationTache.setVisible(true);
        Button_AjouterTache.setDisable(false);
        Dialog_CreationTache.setVisible(false);
    }

    public void creationSplitPane(String nomProjet, String categorie, LocalDate deadline, String priorite,
                                  String description, double coX, double coY, AnchorPane anchorPaneparent){
        //Création splitPane avec ses infos
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);

        VBox vbox = new VBox(10);

        Label labelNomTache = new Label(nomProjet);
        Label labelCategorie = new Label("Catégorie : " + categorie );
        Label labelpriorite = new Label("Priorité : " + priorite);
        Label labeldeadline = new Label("Deadline : " + deadline.toString());
        Label labelDescription = new Label("Description : " + description);

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
        splitPane.setDividerPositions(0.2);

        splitPane.setLayoutX(coX);
        splitPane.setLayoutY(coY);

        splitPane.setPrefSize(200, 250);
        if (!anchorPaneparent.getChildren().contains(splitPane)) {
            anchorPaneparent.getChildren().add(splitPane);
        }
        //Création ContextMenu
        ContextMenu contextMenu = new ContextMenu();

        MenuItem modifier = new MenuItem("Modifier");
        MenuItem supprimer = new MenuItem("Supprimer");
        contextMenu.getItems().addAll(modifier,supprimer);

        modifier.setOnAction(event ->{
            for (Projet projet : Projet.tousLesProjets) {
                if (Projet.projetSelectionnee.getNomDuProjet() == projet.getNomDuProjet()) {
                    StackPane paneHaut2 = (StackPane) splitPane.getItems().get(0);

                    Label labelNomTache2 = (Label) paneHaut2.getChildren().get(0);
                    nomTacheselec = labelNomTache2.getText();
                    for (Tache tache : projet.getListeDesTaches()){
                        if (tache.getNomTache() == nomTacheselec){
                            Projet.tacheParNom(nomTacheselec,projet.getNomDuProjet());
                        }
                    }

                    Tache.supprimerTache(labelNomTache2.getText(), projet);
                    Projet.projetSelectionnee.getListeDesTaches().remove(Tache.tacheSelectionnee);

                    AnchorPane_Parent.getChildren().remove(splitPane);
                    dictTacheToSplitPane.remove(Tache.tacheSelectionnee.getNomTache());


                    Button_CreationTache.setVisible(false);

                    TextField_CreationTache.clear();
                    TextField_Categorie.clear();
                    DatePicker_Deadline.setValue(null);
                    ;
                    TextField_Priorite.clear();
                    TextArea_Description.clear();

                    Dialog_CreationTache.setVisible(true);
                    Dialog_CreationTache.toFront();

                    Button_AjouterTache.setDisable(false);
                }
            }
        });
        supprimer.setOnAction(event ->{
            for (Projet projet : Projet.tousLesProjets){
                if (Projet.projetSelectionnee.getNomDuProjet() == projet.getNomDuProjet()){
                    StackPane paneHaut2 = (StackPane) splitPane.getItems().get(0);

                    Label labelNomTache2 = (Label) paneHaut2.getChildren().get(0);
                    nomTacheselec = labelNomTache2.getText();
                    for (Tache tache : projet.getListeDesTaches()){
                        if (tache.getNomTache() == nomTacheselec){
                            Projet.tacheParNom(nomTacheselec,projet.getNomDuProjet());
                        }
                    }

                    Tache.supprimerTache(labelNomTache2.getText(), projet);
                    Projet.projetSelectionnee.getListeDesTaches().remove(Tache.tacheSelectionnee);
                    AnchorPane_Parent.getChildren().remove(splitPane);
                    dictTacheToSplitPane.remove(Tache.tacheSelectionnee.getNomTache());
                }
            }
        });

        splitPane.setOnMouseClicked(event ->{
            if (event.getButton() == MouseButton.SECONDARY){
                oldX = splitPane.localToScene(0, 0).getX();
                oldY = splitPane.localToScene(0, 0).getY();
                System.out.println("Le SplitPane est à : (" + oldX + ", " + oldY + ")");
                contextMenu.show(splitPane, event.getScreenX(), event.getScreenY());
            }
        });
        dictTacheToSplitPane.put(TextField_CreationTache.getText(), splitPane);
        if (!anchorPaneparent.getChildren().contains(splitPane)) {
            anchorPaneparent.getChildren().add(splitPane);
        }
    }
}
