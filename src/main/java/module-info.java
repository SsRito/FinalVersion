module com.sauharda.oop_projects.group_42 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sauharda.oop_projects.group_42 to javafx.fxml;
    exports com.sauharda.oop_projects.group_42;

    opens Sauharda to javafx.fxml;
    exports Sauharda;

}