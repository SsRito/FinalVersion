package com.sauharda.oop_projects.group_42;

import Sauharda.KeyUpdate;
import Sauharda.Partnership;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class NotificationController
{
    @javafx.fxml.FXML
    private TableColumn<KeyUpdate, String> announcementForTableColumn;
    @javafx.fxml.FXML
    private TableColumn<KeyUpdate, String> dateTableColumn;
    @javafx.fxml.FXML
    private TableView<KeyUpdate> notificationTableView;
    @javafx.fxml.FXML
    private TableColumn<KeyUpdate, String> announcementTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        announcementForTableColumn.setCellValueFactory(new PropertyValueFactory<KeyUpdate, String>("announcementFor"));
        announcementTableColumn.setCellValueFactory(new PropertyValueFactory<KeyUpdate, String>("announcement"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<KeyUpdate, String>("date"));
    }

    @javafx.fxml.FXML
    public void refreshNotificationButton(ActionEvent actionEvent) {
        notificationTableView.getItems().clear();
        File f = new File("keyUpdateDetails.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                KeyUpdate k = new KeyUpdate(tokens[0], tokens[1], LocalDate.parse(tokens[2]));
                notificationTableView.getItems().add(k);
            }

        } catch (Exception e) {
            //
        }
    }
}