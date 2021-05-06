package ScheduleSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class DayPicker {

    private List<Employee> employees = new ArrayList<>();
    private Employee currentEmployee;
    private int counter = 0;

    @FXML
    private VBox checkBoxList1, checkBoxList2, checkBoxList3, checkBoxList4;

    @FXML
    private CheckBox date1, date2, date3, date4, date5, date6,
            date7, date8, date9, date10, date11, date12, date13,
            date14, date15, date16, date17, date18, date19, date20,
            date21, date22, date23, date24, date25, date26, date27,
            date28, date29, date30, date31;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
        employees = Controller.getEmployees();
        currentEmployee = employees.get(counter);
        counter++;
        nameLabel.setText("Pick days that " + currentEmployee.getName() + " cannot work.");
    }

    @FXML
    private void nextEmployee(ActionEvent evt){
        Set<String> days = new HashSet<>();

        for(Node tempNode : checkBoxList1.getChildren()){
            if(tempNode instanceof CheckBox && ((CheckBox) tempNode).isSelected()){
                days.add(((CheckBox) tempNode).getText());
            }
        }

        for(Node tempNode : checkBoxList2.getChildren()){
            if(tempNode instanceof CheckBox && ((CheckBox) tempNode).isSelected()){
                days.add(((CheckBox) tempNode).getText());
            }
        }

        for(Node tempNode : checkBoxList3.getChildren()){
            if(tempNode instanceof CheckBox && ((CheckBox) tempNode).isSelected()){
                days.add(((CheckBox) tempNode).getText());
            }
        }

        for(Node tempNode : checkBoxList4.getChildren()){
            if(tempNode instanceof CheckBox && ((CheckBox) tempNode).isSelected()){
                days.add(((CheckBox) tempNode).getText());
            }
        }

        currentEmployee.setDays(days);

        if(counter < employees.size()){
            currentEmployee = employees.get(counter);
            nameLabel.setText("Pick days that " + currentEmployee.getName() + " cannot work.");
            counter++;
            date1.setSelected(false);
            date2.setSelected(false);
            date3.setSelected(false);
            date4.setSelected(false);
            date5.setSelected(false);
            date6.setSelected(false);
            date7.setSelected(false);
            date8.setSelected(false);
            date9.setSelected(false);
            date10.setSelected(false);
            date11.setSelected(false);
            date12.setSelected(false);
            date13.setSelected(false);
            date14.setSelected(false);
            date15.setSelected(false);
            date16.setSelected(false);
            date17.setSelected(false);
            date18.setSelected(false);
            date19.setSelected(false);
            date20.setSelected(false);
            date21.setSelected(false);
            date22.setSelected(false);
            date23.setSelected(false);
            date24.setSelected(false);
            date25.setSelected(false);
            date26.setSelected(false);
            date27.setSelected(false);
            date28.setSelected(false);
            date29.setSelected(false);
            date30.setSelected(false);
            date31.setSelected(false);
        }else{
            done(evt);
        }
    }

    @FXML
    public void done(ActionEvent evt) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TimePicker.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Scheduling System");
            stage.setScene(new Scene(root, 1100, 700));
            stage.show();
            hide(evt);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
