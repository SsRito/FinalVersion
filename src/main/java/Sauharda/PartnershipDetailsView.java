package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class PartnershipDetailsView
{
    @javafx.fxml.FXML
    private TableColumn<Partnership, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Partnership, String> amountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Partnership, String> companyNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Partnership, String> proposalDetailsTableColumn;
    @javafx.fxml.FXML
    private TableView<Partnership> partnershipDetailsTableView;
    @javafx.fxml.FXML
    private TableColumn<Partnership, String> dateTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        companyNameTableColumn.setCellValueFactory(new PropertyValueFactory<Partnership, String>("companyName"));
        proposalDetailsTableColumn.setCellValueFactory(new PropertyValueFactory<Partnership, String>("proposalDetails"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Partnership, String>("status"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Partnership, String>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Partnership, String>("amount"));
    }

    @javafx.fxml.FXML
    public void refreshTableOnAction(ActionEvent actionEvent) {
        partnershipDetailsTableView.getItems().clear();
        File f = new File("partnershipDetails.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Partnership p = new Partnership(tokens[0], tokens[1], tokens[2], LocalDate.parse(tokens[3]), Integer.parseInt(tokens[4]));
                partnershipDetailsTableView.getItems().add(p);
            }

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/ceoDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("CEO Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToPartnershipWindowOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/partnership-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Partnership");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}