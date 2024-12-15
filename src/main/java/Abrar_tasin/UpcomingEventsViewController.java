package Abrar_tasin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpcomingEventsViewController implements Initializable {

    @FXML
    private TableView<Event> eventsInfo;

    @FXML
    private TableColumn<Event, String> dateTableColumn;

    @FXML
    private TableColumn<Event, String> eventNameTableColumn;

    @FXML
    private TableColumn<Event, String> descriptionTableColumn;

    private ObservableList<Event> eventList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Sample data
        eventList = FXCollections.observableArrayList(
                new Event(LocalDate.of(2024, 12, 22), "Event 1", "Shelter from the Storm (Homelessness)"),
                new Event(LocalDate.of(2024, 12, 24), "Event 2", "Making a Difference Together"),
                new Event(LocalDate.of(2024, 12, 27), "Event 3", "Hearts for Humanity"),
                new Event(LocalDate.of(2024, 12, 29), "Event 4", "Ensure One-day Meal for Street Child"),
                new Event(LocalDate.of(2024, 12, 31), "Event 5", "Winter Clothes for Homeless People")
);
        // Set items for the TableView
        eventsInfo.setItems(eventList);
    }



    // Event class with properties
    public static class Event {
        private StringProperty date;
        private StringProperty eventName;
        private StringProperty description;

        public Event(LocalDate date, String eventName, String description) {
            this.date = new SimpleStringProperty(date.toString());
            this.eventName = new SimpleStringProperty(eventName);
            this.description = new SimpleStringProperty(description);
        }

        public StringProperty dateProperty() {
            return date;
        }

        public StringProperty eventNameProperty() {
            return eventName;
        }

        public StringProperty descriptionProperty() {
            return description;
        }

        public String getDate() {
            return date.get();
        }

        public String getEventName() {
            return eventName.get();
        }

        public String getDescription() {
            return description.get();
        }
    }
    @FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/BeneficiaryDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Donor Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}