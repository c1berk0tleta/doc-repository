package com.example.doc_repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class mysql_db {

    public ObservableList<info> listInfo = FXCollections.observableArrayList();
    public ObservableList<realty> listRealty = FXCollections.observableArrayList();
    public ObservableList<user> listUser = FXCollections.observableArrayList();
    public ObservableList<doc> listDoc = FXCollections.observableArrayList();
    static Connection sqlConnect;

    public static Connection ConnectDB() {
        controller controller = new controller();
        String url = controller.url;
        String user = controller.user;
        String password = controller.password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConnect = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение к базе данных успешно установлено!");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            controller.printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void dataInfo() {
        ConnectDB();
        String query = "SELECT * FROM info";
        try {
            Statement statement = sqlConnect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listInfo.add(new info(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getInt(4)));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void dataRealty() {
        ConnectDB();
        String query = "SELECT * FROM realty";
        try {
            Statement statement = sqlConnect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listRealty.add(new realty(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

//    public void dataDocForInfo() {
//        ConnectDB();
//        String query = "SELECT * FROM doc WHERE realty_id =" + controller.tableDoc.getColumns().get(1).getCellData(1).toString();
//    }

    public void dataUser() {
        ConnectDB();
        String query = "SELECT * FROM user";
        try {
            Statement statement = sqlConnect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listUser.add(new user(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
    public void dataDoc() {
        ConnectDB();
        String query = "SELECT * FROM doc";
        try {
            Statement statement = sqlConnect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listDoc.add(new doc(resultSet.getInt(1), resultSet.getInt(2), resultSet.getBlob(3)));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
