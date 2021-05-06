package ScheduleSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScheduleDisplay {

    private static List<Week> weeks;
    private List<Employee> employees = new ArrayList<>();



    @FXML
    private Label label00, label01,label02,label03,label04,label05,label06,
            label10,label11,label12,label13,label14,label15,label16,
            label20,label21,label22,label23,label24,label25,label26,
            label30,label31,label32,label33,label34,label35,label36,
            label40,label41,label42,label43,label44,label45,label46;

    @FXML
    private Label totalHours1,totalHours2,totalHours3,totalHours4,totalHours5;

    @FXML
    private Label date00, date01,date02,date03,date04,date05,date06,
            date10,date11,date12,date13,date14,date15,date16,
            date20,date21,date22,date23,date24,date25,date26,
            date30,date31,date32,date33,date34,date35,date36,
            date40,date41,date42,date43,date44,date45,date46;

    @FXML
    public void initialize() {

        employees = Controller.getEmployees();
        weeks = createMonth();

        changeSchedule();
    }

    private List<Week> createMonth(){

        List<Week> month = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            month.add(new Week());
        }

        return month;
    }

    @FXML
    public void done(ActionEvent evt) {
        hide(evt);
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void generateSchedule(ActionEvent evt){
        for(Employee currentEmployee : employees){
            for(Week week : weeks){
                for(Day day : week.getDays()){

                    int count = 0;

                    while(currentEmployee.canWorkWeek() && !currentEmployee.hasWorkedDay() && !currentEmployee.getDays().contains(String.valueOf(day.getNumberInMonth())) && count < 400){

                        String[] arrayNumbers = currentEmployee.getHours().toArray(new String[0]);
                        Random rndm = new Random();
                        int rndmNumber = rndm.nextInt(currentEmployee.getHours().size());
                        String time = arrayNumbers[rndmNumber];

                        if(currentEmployee.getCanOpen() || !time.startsWith("10")){
                            if(day.addEmployeeToSchedule(time, currentEmployee)) {
                                currentEmployee.workedDay();
                                currentEmployee.adjustTotalHours(time);
                            }
                        }

                        count++;
                    }
                    currentEmployee.newDay();
                }

                currentEmployee.newWeek();
            }

            currentEmployee.reset();
        }

        changeSchedule();

        for(Week week : weeks){
            week.reset();
        }

    }


    private void changeSchedule(){
        Week week = weeks.get(0);
        List<Day> days = week.getDays();

        label00.setText(days.get(0).getSchedule());
        label01.setText(days.get(1).getSchedule());
        label02.setText(days.get(2).getSchedule());
        label03.setText(days.get(3).getSchedule());
        label04.setText(days.get(4).getSchedule());
        label05.setText(days.get(5).getSchedule());
        label06.setText(days.get(6).getSchedule());

        date00.setText(String.valueOf(days.get(0).getNumberInMonth()));
        date01.setText(String.valueOf(days.get(1).getNumberInMonth()));
        date02.setText(String.valueOf(days.get(2).getNumberInMonth()));
        date03.setText(String.valueOf(days.get(3).getNumberInMonth()));
        date04.setText(String.valueOf(days.get(4).getNumberInMonth()));
        date05.setText(String.valueOf(days.get(5).getNumberInMonth()));
        date06.setText(String.valueOf(days.get(6).getNumberInMonth()));

        totalHours1.setText(week.getTotalHours());

        week = weeks.get(1);
        days = week.getDays();

        label10.setText(days.get(0).getSchedule());
        label11.setText(days.get(1).getSchedule());
        label12.setText(days.get(2).getSchedule());
        label13.setText(days.get(3).getSchedule());
        label14.setText(days.get(4).getSchedule());
        label15.setText(days.get(5).getSchedule());
        label16.setText(days.get(6).getSchedule());

        date10.setText(String.valueOf(days.get(0).getNumberInMonth()));
        date11.setText(String.valueOf(days.get(1).getNumberInMonth()));
        date12.setText(String.valueOf(days.get(2).getNumberInMonth()));
        date13.setText(String.valueOf(days.get(3).getNumberInMonth()));
        date14.setText(String.valueOf(days.get(4).getNumberInMonth()));
        date15.setText(String.valueOf(days.get(5).getNumberInMonth()));
        date16.setText(String.valueOf(days.get(6).getNumberInMonth()));

        totalHours2.setText(week.getTotalHours());

        week = weeks.get(2);
        days = week.getDays();

        label20.setText(days.get(0).getSchedule());
        label21.setText(days.get(1).getSchedule());
        label22.setText(days.get(2).getSchedule());
        label23.setText(days.get(3).getSchedule());
        label24.setText(days.get(4).getSchedule());
        label25.setText(days.get(5).getSchedule());
        label26.setText(days.get(6).getSchedule());

        date20.setText(String.valueOf(days.get(0).getNumberInMonth()));
        date21.setText(String.valueOf(days.get(1).getNumberInMonth()));
        date22.setText(String.valueOf(days.get(2).getNumberInMonth()));
        date23.setText(String.valueOf(days.get(3).getNumberInMonth()));
        date24.setText(String.valueOf(days.get(4).getNumberInMonth()));
        date25.setText(String.valueOf(days.get(5).getNumberInMonth()));
        date26.setText(String.valueOf(days.get(6).getNumberInMonth()));

        totalHours3.setText(week.getTotalHours());

        week = weeks.get(3);
        days = week.getDays();

        label30.setText(days.get(0).getSchedule());
        label31.setText(days.get(1).getSchedule());
        label32.setText(days.get(2).getSchedule());
        label33.setText(days.get(3).getSchedule());
        label34.setText(days.get(4).getSchedule());
        label35.setText(days.get(5).getSchedule());
        label36.setText(days.get(6).getSchedule());

        date30.setText(String.valueOf(days.get(0).getNumberInMonth()));
        date31.setText(String.valueOf(days.get(1).getNumberInMonth()));
        date32.setText(String.valueOf(days.get(2).getNumberInMonth()));
        date33.setText(String.valueOf(days.get(3).getNumberInMonth()));
        date34.setText(String.valueOf(days.get(4).getNumberInMonth()));
        date35.setText(String.valueOf(days.get(5).getNumberInMonth()));
        date36.setText(String.valueOf(days.get(6).getNumberInMonth()));

        totalHours4.setText(week.getTotalHours());

        week = weeks.get(4);
        days = week.getDays();

        label40.setText(days.get(0).getSchedule());
        label41.setText(days.get(1).getSchedule());
        label42.setText(days.get(2).getSchedule());
        label43.setText(days.get(3).getSchedule());
        label44.setText(days.get(4).getSchedule());
        label45.setText(days.get(5).getSchedule());
        label46.setText(days.get(6).getSchedule());

        date40.setText(String.valueOf(days.get(0).getNumberInMonth()));
        date41.setText(String.valueOf(days.get(1).getNumberInMonth()));
        date42.setText(String.valueOf(days.get(2).getNumberInMonth()));
        date43.setText(String.valueOf(days.get(3).getNumberInMonth()));
        date44.setText(String.valueOf(days.get(4).getNumberInMonth()));
        date45.setText(String.valueOf(days.get(5).getNumberInMonth()));
        date46.setText(String.valueOf(days.get(6).getNumberInMonth()));

        totalHours5.setText(week.getTotalHours());
    }


}
