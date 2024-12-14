package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class GenerateComplianceReportController
{
    @javafx.fxml.FXML
    private TableColumn<PolicyCompliance, String> correctiveActionsTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PolicyCompliance, String> detailsTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PolicyCompliance, String> deadlineTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PolicyCompliance, String> complianceStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<PolicyCompliance, String> policyNameTableColumn;
    @javafx.fxml.FXML
    private TableView<PolicyCompliance> complianceTableView;

    @javafx.fxml.FXML
    public void initialize() {
        policyNameTableColumn.setCellValueFactory(new PropertyValueFactory<PolicyCompliance, String>("policyName"));
        complianceStatusTableColumn.setCellValueFactory(new PropertyValueFactory<PolicyCompliance, String>("complianceStatus"));
        detailsTableColumn.setCellValueFactory(new PropertyValueFactory<PolicyCompliance, String>("details"));
        correctiveActionsTableColumn.setCellValueFactory(new PropertyValueFactory<PolicyCompliance, String>("correctiveAction"));
        deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<PolicyCompliance, String>("deadline"));
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/hrManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Hr Manager");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToPolicyCompliancePageOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/policyCompliance-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Policy Compliance");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void generateTableOnAction(ActionEvent actionEvent) {
        complianceTableView.getItems().clear();
        File f = new File("policyComplianceDetails.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                PolicyCompliance c = new PolicyCompliance(tokens[0], tokens[1], tokens[2], tokens[3], LocalDate.parse(tokens[4]));
                complianceTableView.getItems().add(c);
            }

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void sendReportReportOnAction(ActionEvent actionEvent) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Sent Successfully");
        confirmAlert.show();
    }
}