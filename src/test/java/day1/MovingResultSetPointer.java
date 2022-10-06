package day1;

import java.sql.*;

public class MovingResultSetPointer {

    public static void main(String[] args) throws SQLException {

        // we want to create a statement object that generate
        // ResultSet that can move forward  and backward anytime
        String connectionStr = "jdbc:oracle:thin:@54.145.157.201:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        // this way of creating statement will give you ability to generate
        // ResultSet that can move forward and backward anytime
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        while (resultSet.next()){
            System.out.println("REGION_NAME " + resultSet.getString("REGION_NAME"));
        }

//        resultSet.previous();
//        System.out.println("REGION_NAME " + resultSet.getString("REGION_NAME"));
        while (resultSet.previous()){
            System.out.println("BACKWARD - REGION_NAME " + resultSet.getString("REGION_NAME"));
        }
        /**
         *  Other resultSet methods for moving your pointer to specific locations
         */
      resultSet.beforeFirst(); // before first location
      resultSet.first(); // first row
      resultSet.last(); // last row
      resultSet.afterLast(); // after last location
      resultSet.absolute(3); // move to specific row

         // how to find out which row the pointer is at right now
         int currentRowNum = resultSet.getRow();

    }
}
