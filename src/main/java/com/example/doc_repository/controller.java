package com.example.doc_repository;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.doc_repository.mysql_db.sqlConnect;


public class controller implements Initializable {
    mysql_db mysqlDB = new mysql_db();
    String url = "jdbc:mysql://109.126.196.146:3306/doc-repository";
    String user = "c1berk0tleta";
    String password = "os1R$USNES$";
    public Connection connection;

    @FXML
    private TableColumn<info, String> infoAddress;

    @FXML
    private TableColumn<info, Integer> infoID;

    @FXML
    private TableColumn<info, Integer> infoRealtyID;

    @FXML
    private TableColumn<info, Blob> infoPhoto;

    @FXML
    private TableColumn<info, Integer> infoStatusID;

    @FXML
    private TableColumn<info, Integer> infoType;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuTables_info;
    @FXML
    private Menu tables;
    @FXML
    private TextField logField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button authButton;
    @FXML
    private Text textAuthError;
    @FXML
    private AnchorPane logPane;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TableView<info> tableInfo;
    @FXML
    private TableView<realty> tableRealty;
    @FXML
    private TableColumn<realty, Integer> realtyID;
    @FXML
    private TableColumn<realty, String> realtyName;
    @FXML
    private TableColumn<realty, String> realtyType;

    @FXML
    private TableView<user> tableUser;
    @FXML
    private TableColumn<user, Integer> userID;
    @FXML
    private TableColumn<user, String> userLogin;
    @FXML
    private TableColumn<user, String> userPassword;
    @FXML
    private TableColumn<user, Integer> userprivilege;

    @FXML
    public TableView<doc> tableDoc;
    @FXML
    private TableColumn<doc, Integer> docID;
    @FXML
    private TableColumn<doc, Integer> docRealtyID;
    @FXML
    private TableColumn<doc, Blob> docFile;


    @FXML
    protected void Login() throws InterruptedException {
//        String query = "SELECT login, password FROM users";
        String query = "SELECT login, password FROM users WHERE login LIKE '"+logField.getText()+"'";
        String loginAuth = "";
        String passAuth = "";
        try {
            Statement statement = sqlConnect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                loginAuth = resultSet.getString(1);
                passAuth = resultSet.getString(2);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        if (logField.getText().equals("") | passField.getText().equals("")) {
            textAuthError.setVisible(true);
            textAuthError.setText("Введите логин и пароль");
        } else if (logField.getText().equals(loginAuth) && passField.getText().equals(passAuth)) {
            logPane.setVisible(false);
            mainPane.setVisible(true);

        } else {
            textAuthError.setText("Неверный логин или пароль!");
            textAuthError.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mysqlDB.ConnectDB();
    }

    @FXML
    protected void outputInfo() {
        tableRealty.setVisible(false);
        tableUser.setVisible(false);
        tableDoc.setVisible(false);
        tableInfo.setVisible(true);
        tableInfo.getItems().clear();
        mysqlDB.dataInfo();
        try {
            infoID.setCellValueFactory(new PropertyValueFactory<info, Integer>("info_id"));
            infoRealtyID.setCellValueFactory(new PropertyValueFactory<info, Integer>("realty_id"));
            infoAddress.setCellValueFactory(new PropertyValueFactory<info, String>("address"));
            infoStatusID.setCellValueFactory(new PropertyValueFactory<info, Integer>("status_id"));
            infoPhoto.setCellValueFactory(new PropertyValueFactory<info, Blob>("photo"));

            tableInfo.setItems(mysqlDB.listInfo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void outputRealty() {
        tableInfo.setVisible(false);
        tableUser.setVisible(false);
        tableDoc.setVisible(false);
        tableRealty.setVisible(true);
        tableRealty.getItems().clear();
        mysqlDB.dataRealty();
        try {
            realtyID.setCellValueFactory(new PropertyValueFactory<realty, Integer>("realty_id"));
            realtyName.setCellValueFactory(new PropertyValueFactory<realty, String>("realty_name"));
            realtyType.setCellValueFactory(new PropertyValueFactory<realty, String>("type"));

            tableRealty.setItems(mysqlDB.listRealty);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void outputUser() {
        tableInfo.setVisible(false);
        tableRealty.setVisible(false);
        tableDoc.setVisible(false);
        tableUser.setVisible(true);
        tableUser.getItems().clear();
        mysqlDB.dataUser();
        try {
            userID.setCellValueFactory(new PropertyValueFactory<user, Integer>("user_ID"));
            userLogin.setCellValueFactory(new PropertyValueFactory<user, String>("user_login"));
            userPassword.setCellValueFactory(new PropertyValueFactory<user, String>("user_password"));
            userprivilege.setCellValueFactory(new PropertyValueFactory<user, Integer>("user_privilege"));

            tableUser.setItems(mysqlDB.listUser);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void outputDoc() {
        tableInfo.setVisible(false);
        tableUser.setVisible(false);
        tableRealty.setVisible(false);
        tableDoc.setVisible(true);
        tableDoc.getItems().clear();
        mysqlDB.dataDoc();
        try {
            docID.setCellValueFactory(new PropertyValueFactory<doc, Integer>("doc_ID"));
            docRealtyID.setCellValueFactory(new PropertyValueFactory<doc, Integer>("docRealty_ID"));
            docFile.setCellValueFactory(new PropertyValueFactory<doc, Blob>("doc_file"));

            tableDoc.setItems(mysqlDB.listDoc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void outputDocFromInfo() {
        tableInfo.setVisible(false);
        tableRealty.setVisible(true);
    }


    @FXML
    protected void sceneNewRealty() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("new-realty.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setTitle("New realty");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sceneNewInfo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("new-info.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setTitle("New info");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sceneNewUser() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("new-user.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setTitle("New user");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void sceneNewDoc() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("new-doc.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setTitle("New doc");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLException: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}