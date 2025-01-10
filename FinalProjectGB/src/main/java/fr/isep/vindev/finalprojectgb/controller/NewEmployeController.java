package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.Employe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewEmployeController {
    @FXML
    private Button Button_CreateEmploye;

    @FXML
    private TextField TextField_Name;

    @FXML
    private TextField TextField_Firstname;

    @FXML
    private TextField TextField_Email;

    @FXML
    private TextField TextField_Tel;

    @FXML
    protected void onButton_CreateEmployeClick() throws IOException {
        String name = TextField_Name.getText();
        String firstname = TextField_Firstname.getText();
        String email = TextField_Email.getText();
        String tel = TextField_Tel.getText();
        int telephone = 0;
        for (int i = 0; i < tel.length(); i++) {
            if (tel.charAt(i) != '0' && tel.charAt(i) != '1' && tel.charAt(i) != '2' && tel.charAt(i) != '3' && tel.charAt(i) != '4' && tel.charAt(i) != '5' && tel.charAt(i) != '6' && tel.charAt(i) != '7' && tel.charAt(i) != '8' && tel.charAt(i) != '9') {
                System.out.println("Le numéro de telephone n'est pas valide !!");
                return;
            }
            telephone = Integer.parseInt(tel);
        }

        Employe.tousLesEmployes.add(new Employe(name, firstname, email, telephone));
    }
}
