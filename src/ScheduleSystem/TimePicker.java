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

    @FXML
    private Button doneButton;

    @FXML
    private VBox checkBoxList;

    @FXML
    private CheckBox checkBox1,
            checkBox2, checkBox3,
            checkBox4, checkBox5,
            checkBox6, checkBox7,
            checkBox8, checkBox9;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
        employees = Controller.getEmployees();
        currentEmployee = employees.get(0);
        nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
        employees.remove(0);

        weeks = createMonth();
    }

    private List<Week> createMonth(){

        List<Week> month = new ArrayList<>();
        for(int i = 0; i < 4; i++){
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
            stage.setScene(new Scene(root, 900, 700));
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

        System.out.println(currentEmployee.getHours().toString());

        for(Week week : weeks){
            for(Day day : week.getDays()){

            while(!currentEmployee.hasWorkedDay()){

                String[] arrayNumbers = currentEmployee.getHours().toArray(new String[0]);
                Random rndm = new Random();
                int rndmNumber = rndm.nextInt(currentEmployee.getHours().size());
                String time = arrayNumbers[rndmNumber];

                if(day.addEmployeeToSchedule(time, currentEmployee)) {
                    currentEmployee.workedDay();
                    currentEmployee.adjustTotalHours(time);
                }
            }
                currentEmployee.newDay();
            }

            currentEmployee.newWeek();
        }

        if(!employees.isEmpty()){
            currentEmployee = employees.get(0);
            nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
            employees.remove(0);
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            checkBox4.setSelected(false);
            checkBox5.setSelected(false);
            checkBox6.setSelected(false);
            checkBox7.setSelected(false);
            checkBox8.setSelected(false);
            checkBox9.setSelected(false);
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
