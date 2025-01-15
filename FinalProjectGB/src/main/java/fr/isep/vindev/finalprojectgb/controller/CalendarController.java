package fr.isep.vindev.finalprojectgb.controller;

import javafx.fxml.FXML;
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

    @FXML
    protected void initialize(){
        updateCalendar();
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

        for (LocalDate day : days) {
            Text dayText = new Text(String.valueOf(day.getDayOfMonth()));
            grid.add(dayText, col, row);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
    }

    private void updateCalendar() {
        List<LocalDate> daysInMonth = getDaysInMonth(firstDayOfMonth);
        updateCalendarGrid(GridPane_Calendar, daysInMonth);
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
        System.out.println("Calendar updated: " + firstDayOfMonth);

    }

    @FXML
    private void onButton_PreviousMonthClick() {
        firstDayOfMonth = firstDayOfMonth.minusMonths(1);
        System.out.println("Previous month: " + firstDayOfMonth);
        updateCalendar();
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
    }

    @FXML
    private void onButton_NextMonthClick() {
        firstDayOfMonth = firstDayOfMonth.plusMonths(1);
        System.out.println("Next month: " + firstDayOfMonth);
        updateCalendar();
        Label_MonthYear.setText(firstDayOfMonth.getMonth().toString() + " " + firstDayOfMonth.getYear());
    }
}
