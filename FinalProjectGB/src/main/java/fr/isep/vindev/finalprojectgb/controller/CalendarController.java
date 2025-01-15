package fr.isep.vindev.finalprojectgb.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarController {
    @FXML
    private AnchorPane AnchorPane_Calendar;

    @FXML
    protected void initialize(){
    GridPane calendarGrid = new GridPane();
    VBox vbox = new VBox(calendarGrid);
    AnchorPane_Calendar.getChildren().add(vbox);
    LocalDate selectedDate = LocalDate.now();
    List<LocalDate> daysInMonth = getDaysInMonth(selectedDate);
    updateCalendarGrid(calendarGrid, daysInMonth);

    }

    private List<LocalDate> getDaysInMonth(LocalDate date) {
        List<LocalDate> days = new ArrayList<>();
        LocalDate firstDay = date.withDayOfMonth(1);
        LocalDate lastDay = date.withDayOfMonth(date.lengthOfMonth());
        for (LocalDate d = firstDay; !d.isAfter(lastDay); d = d.plusDays(1)) {
            days.add(d);
        }
        return days;
    }

    private void updateCalendarGrid(GridPane grid, List<LocalDate> days) {
        grid.getChildren().clear();
        int row = 0;
        int col = 0;
        for (LocalDate day : days) {
            Text dayText = new Text(String.valueOf(day.getDayOfMonth()));
            grid.add(dayText, col, row);
            col++;
            if (col == 7) { // Passer à la ligne suivante après 7 jours (une semaine)
                col = 0;
                row++;
            }
        }
    }
}
