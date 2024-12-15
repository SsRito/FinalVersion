package Abrar_tasin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class EligibilityForBenefitsViewController
{
    @javafx.fxml.FXML
    private RadioButton incomeNoButton;
    @javafx.fxml.FXML
    private RadioButton employedNoButton;
    @javafx.fxml.FXML
    private RadioButton citizenNoButton;
    @javafx.fxml.FXML
    private RadioButton employedYesButton;
    @javafx.fxml.FXML
    private RadioButton citizenYesButton;
    @javafx.fxml.FXML
    private RadioButton incomeYesButton;

    ToggleGroup tg;

    @javafx.fxml.FXML
    private ToggleGroup employedGroup;
    private ToggleGroup incomeGroup;
    private ToggleGroup citizenGroup;

    @javafx.fxml.FXML
    public void initialize() {
        // Create separate ToggleGroups for each question
        employedGroup = new ToggleGroup();
        incomeGroup = new ToggleGroup();
        citizenGroup = new ToggleGroup();

        // Assign buttons to their respective ToggleGroups
        employedYesButton.setToggleGroup(employedGroup);
        employedNoButton.setToggleGroup(employedGroup);
        employedYesButton.setSelected(true); // Default selection

        incomeYesButton.setToggleGroup(incomeGroup);
        incomeNoButton.setToggleGroup(incomeGroup);
        incomeYesButton.setSelected(true); // Default selection

        citizenYesButton.setToggleGroup(citizenGroup);
        citizenNoButton.setToggleGroup(citizenGroup);
        citizenYesButton.setSelected(true); // Default selection
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        RadioButton employedSelection = (RadioButton) employedGroup.getSelectedToggle();
        RadioButton incomeSelection = (RadioButton) incomeGroup.getSelectedToggle();
        RadioButton citizenshipSelection = (RadioButton) citizenGroup.getSelectedToggle();

        // Ensure all ToggleGroup selections are valid (not null)
        if (employedSelection == null || incomeSelection == null || citizenshipSelection == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please answer all the questions before submitting.");
            errorAlert.show();
            return; // Stop execution
        }

        // Check eligibility criteria
        boolean isEligible = employedSelection.getText().equalsIgnoreCase("No") &&
                incomeSelection.getText().equalsIgnoreCase("No") &&
                citizenshipSelection.getText().equalsIgnoreCase("Yes");

        if (isEligible) {
            // Eligible for benefit
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("You are eligible for the benefit!");
            confirmAlert.showAndWait();

            // Redirect to the new benefit view
            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/NewBenefit-view.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());

                stage.setTitle("Beneficiary Dashboard");
                stage.setScene(nextScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging
            }
        } else {
            // Not eligible for benefit
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("You are not eligible for the benefit.");
            errorAlert.show();
        }
    }
}