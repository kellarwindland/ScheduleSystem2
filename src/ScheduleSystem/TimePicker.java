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

public class TimePicker {

    private List<Employee> employees = new ArrayList<>();
    private Employee currentEmployee;
    private int counter = 0;

    @FXML
    private VBox checkBoxList;

    @FXML
    private CheckBox checkBox1,
            checkBox2, checkBox3,
            checkBox4,checkBox5, selectAll;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {

        selectAll.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (selectAll.isSelected()) {
                checkBox1.setSelected(true);
                checkBox2.setSelected(true);
                checkBox3.setSelected(true);
                checkBox4.setSelected(true);
                checkBox5.setSelected(true);
            } else {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                checkBox4.setSelected(false);
                checkBox5.setSelected(false);
            }
        });

        employees = Controller.getEmployees();
        currentEmployee = employees.get(counter);
        nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
        counter++;

    }

    @FXML
    public void done(ActionEvent evt) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ScheduleDisplay.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Scheduling System");
            stage.setScene(new Scene(root, 1300, 1000));
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
                if(!((CheckBox) tempNode).getText().equals("Select All")){
                    times.add(((CheckBox) tempNode).getText());
                }
            }
        }

        currentEmployee.setHours(times);

        if(counter < employees.size()){
            currentEmployee = employees.get(counter);
            nameLabel.setText("Pick times that " + currentEmployee.getName() + " can work.");
            counter++;
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            checkBox4.setSelected(false);
            checkBox5.setSelected(false);
            selectAll.setSelected(false);
        }else{
            done(evt);
        }
    }


    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
