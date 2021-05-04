package ScheduleSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Controller {

    private static List<Employee> employees = new ArrayList<>();
    private final Logger logger = Logger.getLogger("Controller");

    ObservableList<String> openChoices = FXCollections.observableArrayList("Yes", "No");

    @FXML
    private Button nextButton;

    @FXML
    private ChoiceBox<String> open;

    @FXML
    private TextField nameText;

    @FXML
    public void initialize() {

        open.setItems(openChoices);
        open.setValue("No");

        nextButton.disableProperty().bind(
                nameText.textProperty().isEmpty()
        );
    }

    @FXML
    public void namePrompt(ActionEvent evt) {
        Employee tempEmployee = new Employee(nameText.getText(), open.getValue());
        employees.add(tempEmployee);

        logger.info("confirmed: " + tempEmployee.getName());
        resetNameText();
        resetOpenOption();
    }

    @FXML
    public void cancel(ActionEvent evt) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DayPicker.fxml"));
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

    private void resetOpenOption() {
        open.setValue("No");
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

}
