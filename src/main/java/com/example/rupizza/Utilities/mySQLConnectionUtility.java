package com.example.rupizza.Utilities;

import java.sql.*;

public class mySQLConnectionUtility {
    static String url = "jdbc:mysql://127.0.0.1:3306/orders";
    static String username = "root";
    static String password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

//            String sql = "INSERT INTO orders.order (orderID, total) VALUES (?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setInt(2, 777);
//
//            preparedStatement.executeUpdate();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders.order ORDER BY orderID DESC");

            while (resultSet.next()) {
                //System.out.println(resultSet.getString("orderID"));
                System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
