package practiceJDBC;

import java.sql.*;

public class Day1TestConnection {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.83.44.117:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection connection = DriverManager.getConnection(connectionStr,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM REGIONS");
        // this will move the cursor from before first location to first row
        resultSet.next(); // currently we are at the very first row

       // resultSet.getString(column index) can be used to read the data of column in current row
        System.out.println("first column value using index = " + resultSet.getString(1));
        // there is no 0 index in SQL

        // rs.getString(column names)
        System.out.println("resultSet.getString(\"region_id\") = " + resultSet.getString("region_id"));
        System.out.println("resultSet.getString(\"region_name\") = " + resultSet.getString("region_name"));

        resultSet.next(); //  this will move us to next row So we can read next row
        System.out.println("resultSet.getString(\"region_id\") = " + resultSet.getString("region_id"));
        System.out.println("resultSet.getString(\"region_name\") = " + resultSet.getString("region_name"));

        resultSet.next(); // this will move us to next row So we can read next row
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));

        resultSet.next(); // this will move us to next row So we can read next row
        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));
        // What if we want to keep moving ?
//        resultSet.next(); // this will move us to next row So we can read next row
//        System.out.println("REGION_ID at this row is : " + resultSet.getString("REGION_ID"));
//        System.out.println("REGION_Name at this row is : " + resultSet.getString("REGION_NAME"));
//        Exception in thread "main" java.sql.SQLException: Result set after last row
    }
}
