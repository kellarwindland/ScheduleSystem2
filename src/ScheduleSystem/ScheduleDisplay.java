package ScheduleSystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleDisplay {

    @FXML
    private Label label00, label01,label02,label03,label04,label05,label06,
            label10,label11,label12,label13,label14,label15,label16,
            label20,label21,label22,label23,label24,label25,label26,
            label30,label31,label32,label33,label34,label35,label36;

    @FXML
    public void initialize() {

        int index = 0;
        List<Week> weeks = TimePicker.getWeeks();
        Week week = weeks.get(0);
        List<Day> days = week.getDays();

        label00.setText(days.get(0).getSchedule());
        label01.setText(days.get(1).getSchedule());
        label02.setText(days.get(2).getSchedule());
        label03.setText(days.get(3).getSchedule());
        label04.setText(days.get(4).getSchedule());
        label05.setText(days.get(5).getSchedule());
        label06.setText(days.get(6).getSchedule());

        week = weeks.get(1);
        days = week.getDays();

        label10.setText(days.get(0).getSchedule());
        label11.setText(days.get(1).getSchedule());
        label12.setText(days.get(2).getSchedule());
        label13.setText(days.get(3).getSchedule());
        label14.setText(days.get(4).getSchedule());
        label15.setText(days.get(5).getSchedule());
        label16.setText(days.get(6).getSchedule());

        week = weeks.get(3);
        days = week.getDays();

        label20.setText(days.get(0).getSchedule());
        label21.setText(days.get(1).getSchedule());
        label22.setText(days.get(2).getSchedule());
        label23.setText(days.get(3).getSchedule());
        label24.setText(days.get(4).getSchedule());
        label25.setText(days.get(5).getSchedule());
        label26.setText(days.get(6).getSchedule());

        week = weeks.get(3);
        days = week.getDays();

        label30.setText(days.get(0).getSchedule());
        label31.setText(days.get(1).getSchedule());
        label32.setText(days.get(2).getSchedule());
        label33.setText(days.get(3).getSchedule());
        label34.setText(days.get(4).getSchedule());
        label35.setText(days.get(5).getSchedule());
        label36.setText(days.get(6).getSchedule());


//        for(Week week : weeks){
//
//            for(Day day : week.getDays()){
//
//                labelList.get(index).setText(day.getSchedule());
//                index++;
//
//            }
//            index++;
//        }

    }


}
