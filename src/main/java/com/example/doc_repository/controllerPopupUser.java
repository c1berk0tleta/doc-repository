package com.example.doc_repository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.Statement;

public class controllerPopupUser {
    @FXML
    private AnchorPane popupNewUserPane;
    @FXML
    private Button popupUserButton;
    @FXML
    private TextField popupUserLogin;
    @FXML
    private TextField popupUserPassword;
    @FXML
    private Text popupUserprivilege;
    @FXML
    public void popupNewUser(ActionEvent event) {
        String query = "INSERT INTO `doc-repository`.`user` (`login`, `password`, `privilege`) VALUES ('"
                + popupUserLogin.getText() + "','"
                + popupUserPassword.getText() + "','"
                + popupUserprivilege.getText() + "')";
        try {
            Statement state = mysql_db.sqlConnect.createStatement();
            state.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
