package practiceJDBC;

import utility.DB_Utility;

import java.sql.*;

public class Day2Review {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.83.44.117:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM JOBS");

        // I want to read the first row
        resultSet.next(); // reading same line , read next cell
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));// AD_PRES
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));// President

        resultSet.absolute(7);
        System.out.println("First column value in Jobs in row 7 = " + resultSet.getString(1));
        System.out.println("Second column value in Jobs in row 7 = " + resultSet.getString(2));

        resultSet.last();
        System.out.println("First column value in last row = " + resultSet.getString(1));
        System.out.println("Second column value  in last row = " + resultSet.getString(2));

        System.out.println("---------Loop from top to bottom print JOB_ID--------");
        resultSet.beforeFirst(); //Moves the cursor to the front of this ResultSet object, just before the first row.

        while (resultSet.next()){
            System.out.println("Loop First Column = " + resultSet.getString("JOB_ID"));
        }
        System.out.println("\n---------Loop from last row till first row get MIN_SALARY COLUMN AS NUMBER-----");

        resultSet.afterLast(); // Moves the cursor to the end of this ResultSet object, just after the last row
        while (resultSet.previous()){
            // NOTHING WRONG WITH GETTING IT AS STRING , JUST FOR THE SAKE OF DEMO , WE ARE GETTING AS DOUBLE
            System.out.println("MIN SALARY COLUMN AS NUMBER = " + resultSet.getDouble("MIN_SALARY"));
        }

        // CLEAN UP THE CONNECTION , STATEMENT AND RESULTSET OBJECT AFTER USAGE
        // IT CAN BE DUBLICATED, CAN BE CONNECTION PROBLEM

        DB_Utility.destroy();

    }


}
