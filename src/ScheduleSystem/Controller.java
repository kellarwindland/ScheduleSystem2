package ScheduleSystem;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Controller {

    private static List<Employee> employees = new ArrayList<>();
    private Logger logger = Logger.getLogger("Controller");

    @FXML
    private Button nextButton;

    @FXML
    private TextField nameText;

    @FXML
    public void initialize() {

        nextButton.disableProperty().bind(
                nameText.textProperty().isEmpty()
        );
    }

    @FXML
    public void namePrompt(ActionEvent evt) {
        Employee tempEmployee = new Employee(nameText.getText());
        employees.add(tempEmployee);
        // tempEmployee.hoursOff();

        logger.info("confirmed: " + tempEmployee.getName());
        resetNameText();
    }

    @FXML
    public void cancel(ActionEvent evt) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TimePicker.fxml"));
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

    public static List<Employee> getEmployees(){
        return employees;
    }

    private void resetNameText() {
        nameText.setText("");
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
