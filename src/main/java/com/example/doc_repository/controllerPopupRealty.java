package com.example.doc_repository;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Statement;

public class controllerPopupRealty {
    @FXML
    private AnchorPane popupNewRealtyPane;
    @FXML
    private AnchorPane popupNewInfoPane;
    @FXML
    private TextField popupRealtyName;
    @FXML
    private TextField popupRealtyType;
    @FXML
    private Button popupRealtyButton;
    @FXML
    private MenuItem contextNewValue;
    @FXML
    private TextField popupInfoAddress;
    @FXML
    private TextField popupInfoID;
    @FXML
    private TextField popupInfoStatus;
    @FXML
    private Button popupInfoButton;

    @FXML
    protected void popupNewRealty() {
        String query = "INSERT INTO `doc-repository`.`realty` (`realty_name`, `type_id`) VALUES ('" + popupRealtyName.getText() + "', " + popupRealtyType.getText() + ")";
        try {
            Statement state = mysql_db.sqlConnect.createStatement();
            state.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
