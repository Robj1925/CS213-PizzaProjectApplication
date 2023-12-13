package com.example.rupizza;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    private static Order currOrder = new Order();
    private static Store allOrders = new Store();
    public static ObservableList<Order> getAllOrders() {
        return allOrders.getOrders();
    }


    public static Store getStoreObj() {
        return allOrders;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml")); // use this to open up more windows
        Scene scene = new Scene(fxmlLoader.load(), 516, 523); // .load() makes it visible
        stage.setTitle("RU Pizza"); //stage is just window
        stage.setScene(scene);
        stage.show();

    }

    public static void setCurrOrder(Order currOrder) {
        HelloApplication.currOrder = currOrder;
    }

    public static Order getCurrOrder() {
        return currOrder;
    }
    public static boolean addOrderToStore(Order o) {
       return allOrders.add(o);
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/orders";
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders.order");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("total"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        // test case 1
//        Pizza testCase1 = new BuildYourOwn();
//        testCase1.setCrust("pan");
//        testCase1.setCurrentSize("small");
//        testCase1.getToppings().add(Topping.PEPPERONI);
//        System.out.println("Test Case 1:");
//        if(testCase1.price() == 10.58) {
//            System.out.println("Test Case 1, a small pizza with one topping has passed.");
//        }
//        else System.out.println("Test Case 1, a small pizza with one topping has failed.");
//
//        // test case 2
//        Pizza testCase2 = new BuildYourOwn();
//        testCase2.setCrust("deepdish");
//        testCase2.setCurrentSize("medium");
//        testCase2.getToppings().add(Topping.PEPPERONI);
//        testCase2.getToppings().add(Topping.CHEDDAR);
//        System.out.println("Test Case 2:");
//        if(testCase2.price() == 14.17) {
//            System.out.println("Test Case 2, a medium pizza with two toppings has passed.");
//        }
//        else System.out.println("Test Case 2, a medium pizza with two toppings has failed.");
//
//        // test case 3
//        Pizza testCase3 = new BuildYourOwn();
//        testCase3.setCrust("stuffed");
//        testCase3.setCurrentSize("small");
//        testCase3.getToppings().add(Topping.PROVOLONE);
//        testCase3.getToppings().add(Topping.CHEDDAR);
//        System.out.println("Test Case 3:");
//        if(testCase3.price() == 12.17) {
//            System.out.println("Test Case 3, a small pizza with two toppings has passed.");
//        }
//        else System.out.println("Test Case 3, a small pizza with two toppings has failed.");
//
//        // test case 4
//        Pizza testCase4 = new BuildYourOwn();
//        testCase4.setCrust("handtossed");
//        testCase4.setCurrentSize("large");
//        testCase4.getToppings().add(Topping.BEEF);
//        testCase4.getToppings().add(Topping.SAUSAGE);
//        testCase4.getToppings().add(Topping.HAM);
//        System.out.println("Test Case 4:");
//        if(testCase4.price() == 17.76) {
//            System.out.println("Test Case 4, a large pizza with three toppings has passed.");
//        }
//        else System.out.println("Test Case 4, a large pizza with three toppings has failed.");
//
//        // test case 5
//        Pizza testCase5 = new BuildYourOwn();
//        testCase5.setCrust("brooklyn");
//        testCase5.setCurrentSize("medium");
//        testCase5.getToppings().add(Topping.BBQCHICKEN);
//        testCase5.getToppings().add(Topping.BLACKOLIVES);
//        testCase5.getToppings().add(Topping.MUSHROOM);
//        testCase5.getToppings().add(Topping.GREENPEPPER);
//        System.out.println("Test Case 5:");
//        if(testCase5.price() == 17.35) {
//            System.out.println("Test Case 5, a medium pizza with four toppings has passed.");
//        }
//        else System.out.println("Test Case 5, a medium pizza with four toppings has failed.");
//
//        // test case 6
//        Pizza testCase6 = new BuildYourOwn();
//        testCase6.setCrust("thin");
//        testCase6.setCurrentSize("medium");
//        testCase6.getToppings().add(Topping.PINEAPPLE);
//        testCase6.getToppings().add(Topping.BLACKOLIVES);
//        testCase6.getToppings().add(Topping.MUSHROOM);
//        testCase6.getToppings().add(Topping.GREENPEPPER);
//        System.out.println("Test Case 6:");
//        if(testCase6.price() == 15.35) {
//            System.out.println("Test Case 6, a medium pizza with four toppings has passed.");
//        }
//        else System.out.println("Test Case 6, a medium pizza with four toppings has failed.");
//
//        // test case 7
//        Pizza testCase7 = new BuildYourOwn();
//        testCase7.setCrust("brooklyn");
//        testCase7.setCurrentSize("large");
//        testCase7.getToppings().add(Topping.BBQCHICKEN);
//        System.out.println("Test Case 7:");
//        if(testCase7.price() == 14.58) {
//            System.out.println("Test Case 7, a large pizza with one topping has passed.");
//        }
//        else System.out.println("Test Case 7, a large pizza with one topping has failed.");
//
//        // test case 8
//        Pizza testCase8 = new BuildYourOwn();
//        testCase8.setCrust("handtossed");
//        testCase8.setCurrentSize("medium");
//        testCase8.getToppings().add(Topping.BEEF);
//        testCase8.getToppings().add(Topping.SAUSAGE);
//        testCase8.getToppings().add(Topping.HAM);
//        System.out.println("Test Case 8:");
//        if(testCase8.price() == 15.76) {
//            System.out.println("Test Case 8, a medium pizza with three toppings has passed.");
//        }
//        else System.out.println("Test Case 8, a medium pizza with three toppings has failed.");
//
//        // test case 9
//        Pizza testCase9 = new BuildYourOwn();
//        testCase9.setCrust("thin");
//        testCase9.setCurrentSize("small");
//        testCase9.getToppings().add(Topping.PINEAPPLE);
//        testCase9.getToppings().add(Topping.BLACKOLIVES);
//        testCase9.getToppings().add(Topping.MUSHROOM);
//        testCase9.getToppings().add(Topping.GREENPEPPER);
//        testCase9.getToppings().add(Topping.ONION);
//        System.out.println("Test Case 9:");
//        if(testCase9.price() == 16.94) {
//            System.out.println("Test Case 9, a small pizza with five toppings has passed.");
//        }
//        else System.out.println("Test Case 9, a small pizza with five toppings has failed.");
//
//        // test case 10
//        Pizza testCase10 = new BuildYourOwn();
//        testCase10.setCrust("pan");
//        testCase10.setCurrentSize("medium");
//        testCase10.getToppings().add(Topping.SPINACH);
//        System.out.println("Test Case 10:");
//        if(testCase10.price() == 12.58) {
//            System.out.println("Test Case 10, a medium pizza with one topping has passed.");
//        }
//        else System.out.println("Test Case 10, a medium pizza with one topping has failed.");

        launch();
    }
}
// tostring method and printwriter for exporting files
//