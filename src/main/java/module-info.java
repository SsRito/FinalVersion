module com.sauharda.oop_projects.group_42 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sauharda.oop_projects.group_42 to javafx.fxml;
    exports com.sauharda.oop_projects.group_42;

    opens Sauharda to javafx.fxml;
    exports Sauharda;

    opens Farha_Yesmin to javafx.fxml;
    exports Farha_Yesmin;

    opens Abrar_tasin to javafx.fxml;
    exports Abrar_tasin;

}