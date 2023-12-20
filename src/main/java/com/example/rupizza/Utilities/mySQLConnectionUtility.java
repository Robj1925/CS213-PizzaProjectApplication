package com.example.rupizza.Utilities;

import com.example.rupizza.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.util.List;

public class mySQLConnectionUtility {
    static String url = "jdbc:mysql://127.0.0.1:3306/orders";
    static String username = "root";
    static String password = "";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public static boolean setOrder(Order o) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();

            String sql = "INSERT INTO orders.order (orderID, total) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, o.getOrderNumber());
            preparedStatement.setInt(2, (int) o.getTotal());

            return (preparedStatement.executeUpdate() > 0) ? true : false;

       // ResultSet resultSet = statement.executeQuery("SELECT * FROM orders.order ");


    }
    public static List<Order> getOrders() throws SQLException, ClassNotFoundException {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders.order ");

        while (resultSet.next()) {
            Order temp = new Order();
            temp.setOrderNumber(resultSet.getInt("orderID"));
            temp.setTotal((double)resultSet.getInt("total"));
            orders.add(temp);
            //System.out.println(resultSet.getString("orderID"));
            System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2));
        }

        return orders;
    }
}
