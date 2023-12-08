module com.example.demo6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.doc_repository to javafx.fxml;
    exports com.example.doc_repository;
}