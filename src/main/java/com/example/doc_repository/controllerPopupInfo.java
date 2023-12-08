package com.example.doc_repository;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Statement;

public class controllerPopupInfo {
    @FXML
    private TextField popupInfoAddress;
    @FXML
    private Button popupInfoButton;
    @FXML
    private TextField popupInfoID;
    @FXML
    private TextField popupInfoStatus;
    @FXML
    private AnchorPane popupNewInfoPane;
    public void popupNewInfo() {
        String query = "INSERT INTO `doc-repository`.`info` (`realty_id`, `address`, `status`) VALUES ('"
                + popupInfoID.getText() + "','"
                + popupInfoAddress.getText() + "','"
                + popupInfoStatus.getText() + "')";
        try {
            Statement state = mysql_db.sqlConnect.createStatement();
            state.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
