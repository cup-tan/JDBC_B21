package day2;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.145.157.201:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

        // Metadata -- data about the data --
        // ResultSetMetaData -- data about the resultSet object that contain our resulting rows and columns
        // for example column names , column counts ... and more
        // This is how we get the ResultSetMetaData object

        // ResultSetMetaData itself does not contain any row data
        // it only has information about the columns
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        // we only need to methods from this to get column count and column name  / label
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);
        // this is how we get column label / name using index
        // get first column name
        System.out.println("First Column Name is " + resultSetMetaData.getColumnLabel(1));
        System.out.println("Second Column Name is " + resultSetMetaData.getColumnLabel(2));

        // now print out all column names :
        for (int columnNum = 1; columnNum <= columnCount ; columnNum++){
            System.out.println("Column name " + resultSetMetaData.getColumnLabel(columnNum));
        }
        // after using we need to close it
         resultSet.close();
         statement.close();
         connection.close();

    }
}
