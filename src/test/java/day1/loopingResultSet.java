package day1;

import java.sql.*;

public class loopingResultSet {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.145.157.201:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        // resultSet.next() method will return boolean value
        // if there is next row -->> return true and move the pointer to next row
        // if there is no next row -->> false

        while (resultSet.next()) {
//            System.out.println("REGION_ID " + resultSet.getString("REGION_ID"));
//            System.out.println("REGION_NAME " + resultSet.getString("REGION_NAME"));
        }

        // Iterate over all Countries
        resultSet = statement.executeQuery("SELECT * FROM COUNTRIES");
//        resultSet.next();
//        System.out.println(resultSet.getString(1));
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t");
            System.out.print(resultSet.getString(2)+ "\t");
            System.out.println(resultSet.getString(3));
        }
        // Invalid operation for forward only resultSet : previous
        //resultSet.previous();


    }
}
