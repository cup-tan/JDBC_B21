package day2;

import utility.DB_Utility;
import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.145.157.201:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM JOBS");

        // I want to read the first row
        resultSet.next();
        System.out.println("First column value in Jobs " + resultSet.getString(1));
        System.out.println("Second column value in Jobs " + resultSet.getString(2));

        resultSet.absolute(7);
        System.out.println("First column value in Jobs in row 7 " + resultSet.getString(1));
        System.out.println("Second column value in Jobs in row 7 " + resultSet.getString(2));

        resultSet.last();
        System.out.println("First column value in Jobs in row 7 " + resultSet.getString(1));
        System.out.println("Second column value in Jobs in row 7 " + resultSet.getString(2));

        System.out.println("---------Loop from top to bottom print JOB_ID--------");
        resultSet.beforeFirst();

        while (resultSet.next()){
            System.out.println("Loop First Column " + resultSet.getString("JOB_ID"));
        }

        System.out.println("\n---------Loop from last row till first row get MIN_SALARY COLUMN AS NUMBER-----");
        // WE ARE CURRENTLY AT AFTER LAST LOCATION
        // if you really want to make sure and explicitly say so
        // we can do below
        resultSet.afterLast();
        while (resultSet.previous()){
            // NOTHING WRONG WITH GETTING IT AS STRING , JUST FOR THE SAKE OF DEMO , WE ARE GETTING AS DOUBLE
            System.out.println("MIN SALARY COLUMN AS NUMBER " + resultSet.getDouble("MIN_SALARY"));
        }

        // clean up the connection , statement and resultSet object after usage
        DB_Utility.destroy();


    }
}
