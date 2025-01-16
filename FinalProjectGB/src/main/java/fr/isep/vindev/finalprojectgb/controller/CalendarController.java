package fr.isep.vindev.finalprojectgb.controller;

import fr.isep.vindev.finalprojectgb.HelloApplication;
import fr.isep.vindev.finalprojectgb.Projet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarController {
    @FXML
    private GridPane GridPane_Calendar;

    @FXML
    private Label Label_MonthYear;

    @FXML
    private Button Button_PreviousMonth;

    @FXML
    private Button Button_NextMonth;

    private LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);

    private List<Projet> projets = new ArrayList<>();

    @FXML
    protected void initialize(){
        updateCalendar();
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    private List<LocalDate> getDaysInMonth(LocalDate date) {
        List<LocalDate> days = new ArrayList<>();
        LocalDate firstDay = date.withDayOfMonth(1);
        LocalDate lastDay = date.withDayOfMonth(date.lengthOfMonth());
        for (LocalDate day = firstDay; !day.isAfter(lastDay); day = day.plusDays(1)) {
            days.add(day);
        }
        return days;
    }

    private void updateCalendarGrid(GridPane grid, List<LocalDate> days) {
        grid.getChildren().clear();

        int col = 0;
        int row = 0;

        switch (days.get(0).getDayOfWeek()){
            case SUNDAY -> col = 0;
            case MONDAY -> col = 1;
            case TUESDAY -> col = 2;
            case WEDNESDAY -> col = 3;
            case THURSDAY -> col = 4;
            case FRIDAY -> col = 5;
            case SATURDAY -> col = 6;
        }

        Label_MonthYear.setText(days.get(0).getMonth().toString() + " " + days.get(0).getYear());

        ArrayList<Projet> projetsInMonth = new ArrayList<>();
        ArrayList<Projet> projetsInDay = new ArrayList<>();

        for (Projet projet : projets) {
            if (projet.getDeadline().getMonth() == days.get(0).getMonth() && projet.getDeadline().getYear() == days.get(0).getYear()) {
                projetsInMonth.add(projet);
            }
        }
        for (LocalDate day : days) {
            Text dayText = new Text(String.valueOf(day.getDayOfMonth()));
            for (Projet projet : projetsInMonth) {
                if (projet.getDeadline().getDayOfMonth() == day.getDayOfMonth()) {
                    projetsInDay.add(projet);
                }
            }

            VBox vbox = new VBox();
            vbox.getChildren().add(dayText);
            for (Projet projet : projetsInDay) {
                Button projetButton = new Button();
                projetButton.setText(projet.getNomDuProjet());
                projetButton.setStyle("-fx-border-color: #d21a1a; -fx-padding: 5; -fx-alignment: center;");
                projetButton.setUserData(projet);
                projetButton.setOnAction(event -> {
                    try {
                        onButton_ProjetClick(projet);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                vbox.getChildren().add(projetButton);
            }

            grid.add(vbox, col, row);

            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
            projetsInDay.clear();
        }
        projetsInMonth.clear();
    }

    private void updateCalendar() {
        List<LocalDate> daysInMonth = getDaysInMonth(firstDayOfMonth);
        updateCalendarGrid(GridPane_Calendar, daysInMonth);
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
    }

    @FXML
    private void onButton_PreviousMonthClick() {
        firstDayOfMonth = firstDayOfMonth.minusMonths(1);
        updateCalendar();
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
    }

    @FXML
    private void onButton_NextMonthClick() {
        firstDayOfMonth = firstDayOfMonth.plusMonths(1);
        updateCalendar();
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
    }

    @FXML
    protected void onButton_ProjetClick(Projet projet) throws IOException {
        Projet.projetSelectionnee = projet;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProjetApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage newstage = new Stage();
        newstage.setTitle("Projet : " + projet.getNomDuProjet());
        newstage.setScene(scene);

        newstage.show();
    }

}
