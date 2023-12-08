package com.example.doc_repository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class controllerPopupDoc {
    @FXML
    private Button popupDocChooser;
    @FXML
    private TextField popupDocName;
    @FXML
    private AnchorPane popupNewUserPane;
    @FXML
    private Button popupUserButton;

    @FXML
    void popupDocChooseFiles(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Microsoft Word", ".docx"));
        List<File> fl = fc.showOpenMultipleDialog(null);
        for (File file : fl) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @FXML
    void popupNewDoc(ActionEvent event) {

    }

}
