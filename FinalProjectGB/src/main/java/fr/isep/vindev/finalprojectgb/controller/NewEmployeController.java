package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewEmployeController {
    @FXML
    public Button Button_CreateEmploye;

    @FXML
    public TextField TextField_Name;

    @FXML
    public TextField TextField_Firstname;

    @FXML
    public TextField TextField_Email;

    @FXML
    public TextField TextField_Tel;

    public Employe selectedEmploye;

    @FXML
    protected void onButton_CreateEmployeClick() throws IOException {
        if (Button_CreateEmploye.getText() == "Creer") {
            String name = TextField_Name.getText();
            String firstname = TextField_Firstname.getText();
            String email = TextField_Email.getText();
            String tel = TextField_Tel.getText();
            for (int i = 0; i < tel.length(); i++) {
                if (tel.charAt(i) != '0' && tel.charAt(i) != '1' && tel.charAt(i) != '2' && tel.charAt(i) != '3' && tel.charAt(i) != '4' && tel.charAt(i) != '5' && tel.charAt(i) != '6' && tel.charAt(i) != '7' && tel.charAt(i) != '8' && tel.charAt(i) != '9') {
                    System.out.println("Le numéro de telephone n'est pas valide !!");
                    return;
                }
            }

            Employe.tousLesEmployes.add(new Employe(name, firstname, email, tel));

            Stage stage = (Stage) Button_CreateEmploye.getScene().getWindow();
            stage.close();
        }
        if (Button_CreateEmploye.getText() == "Modifier") {
            selectedEmploye.setNom(TextField_Name.getText());
            selectedEmploye.setPrenom(TextField_Firstname.getText());
            selectedEmploye.setEmail(TextField_Email.getText());
            selectedEmploye.setTelephone(TextField_Tel.getText());
            Stage stage = (Stage) Button_CreateEmploye.getScene().getWindow();
            stage.close();
        }
    }
}
