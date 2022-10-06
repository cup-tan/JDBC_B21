package day1;

import java.sql.*;

public class TestConnection {
    // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER
    public static void main(String[] args) throws SQLException {
        String connectionStr ="jdbc:oracle:thin:@54.209.224.232:1521:XE";
        String username ="hr";
        String password ="hr";
        Connection connection = DriverManager.getConnection(connectionStr,username,password);

        Statement statement = connection.createStatement(); //  query statament
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");
        // this will move the cursor from before first location to first row
        resultSet.next(); // currently we are at the very first row
        //rs.getString(clomun index) can be used to read the data of that column in current row
        System.out.println("first column value using index = --> " + resultSet.getString(1));
        // there is no 0 index in SQL
        System.out.println("second column value using index = --> " + resultSet.getString(2));

        // rs.getString(column names)
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));

        resultSet.next(); // this will move us to next row So we can read next row
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));

        resultSet.next(); // this will move us to next row So we can read next row
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));

        resultSet.next(); // this will move us to next row So we can read next row
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));
        // What if we want to keep moving ?
    }
}
