package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Database {
    static String url = "jdbc:postgresql://localhost:5432/";
    static String username = "postgres";
    static String password = "suba2002";

    static Statement statement;

    static void connectionCreation(String shopName){
        try {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            Database.databaseCreation(shopName);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection to the database failed!");
        }
    }

    public static void databaseCreation(String shopName){
        try {
            statement.executeUpdate("create database "+shopName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTables(){
        try {
            statement.executeUpdate(sqlQuery.category_table);
            statement.executeUpdate(sqlQuery.product_table);
            statement.executeUpdate(sqlQuery.purchase_table);
            statement.executeUpdate(sqlQuery.sales_table);
        } catch (SQLException e) {
            System.out.println("Tables creation failed!");
        }
    }

    public static void insertIntoTable(String tableName, List<String> values){

    }
}

