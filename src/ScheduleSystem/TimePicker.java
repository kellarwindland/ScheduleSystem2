package ScheduleSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class TimePicker {

    private List<Employee> employees = new ArrayList<>();
    private Employee currentEmployee;
    private static List<Week> weeks;
    private static Map<Employee, Set<String>> employeeTimeMap = new HashMap<>();
    private int counter = 0;

    @FXML
    private VBox checkBoxList;

    @FXML
    private CheckBox checkBox1,
            checkBox2, checkBox3,
            checkBox4;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
        employees = Controller.getEmployees();
        currentEmployee = employees.get(counter);
        nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
        counter++;

        //weeks = createMonth();
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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ScheduleDisplay.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Scheduling System");
            stage.setScene(new Scene(root, 1200, 900));
            stage.show();
            hide(evt);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void nextEmployee(ActionEvent evt){
        Set<String> times = new HashSet<>();

        for(Node tempNode : checkBoxList.getChildren()){
            if(tempNode instanceof CheckBox && ((CheckBox) tempNode).isSelected()){
                times.add(((CheckBox) tempNode).getText());
            }
        }

        currentEmployee.setHours(times);


//        for(Week week : weeks){
//            for(Day day : week.getDays()){
//
//                int count = 0;
//
//            while(currentEmployee.canWorkWeek() && !currentEmployee.hasWorkedDay() && !currentEmployee.getDays().contains(String.valueOf(day.getNumberInMonth())) && count < 400){
//
//                String[] arrayNumbers = currentEmployee.getHours().toArray(new String[0]);
//                Random rndm = new Random();
//                int rndmNumber = rndm.nextInt(currentEmployee.getHours().size());
//                String time = arrayNumbers[rndmNumber];
//
//                if(currentEmployee.getCanOpen() || !time.startsWith("10")){
//                    if(day.addEmployeeToSchedule(time, currentEmployee)) {
//                        currentEmployee.workedDay();
//                        currentEmployee.adjustTotalHours(time);
//                    }
//                }
//
//                count++;
//            }
//                currentEmployee.newDay();
//            }
//
//            currentEmployee.newWeek();
//        }
//
        if(counter < employees.size()){
            currentEmployee = employees.get(counter);
            nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
            counter++;
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            checkBox4.setSelected(false);
        }else{
            done(evt);
        }
    }

    public static List<Week> getWeeks(){
        return weeks;
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
