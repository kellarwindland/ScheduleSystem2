package ScheduleSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimePicker {

    private static List<Employee> employees = new ArrayList<>();
    private static Employee currentEmployee;

    @FXML
    private Button nextButton;

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
    }

    @FXML
    public void done(ActionEvent evt) {
        hide(evt);
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

        if(!employees.isEmpty()){
            currentEmployee = employees.get(0);
            nameLabel.setText(currentEmployee.getName());
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
            hide(evt);
        }
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
