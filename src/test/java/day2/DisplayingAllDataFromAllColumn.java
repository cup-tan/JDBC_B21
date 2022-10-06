package day2;

import utility.DB_Utility;

import java.sql.*;

public class DisplayingAllDataFromAllColumn {

    public static void main(String[] args) throws SQLException {
        DB_Utility.createConnection();
        ResultSet resultSet = DB_Utility.runQuery("SELECT * FROM EMPLOYEES");

        // print out entire first row of Employee table from above query
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        // print out column name in the beginning riw , then print first row

        for (int colNum = 1; colNum <= columnCount; colNum++) {
            System.out.print(resultSetMetaData.getColumnLabel(colNum) + "\t");
        }
        System.out.println("---------------------------");
        resultSet.next();

        // this whole loop is getting one row of data
        for (int colNum = 1; colNum <= columnCount; colNum++) {
            System.out.print(resultSet.getString(colNum) + "\t"); // getString --> getting real data
        }

        // now how do you get all the row if you know how to get one row ???
        // I want to go from the first row till the last row and print all columns
        resultSet.beforeFirst();

        while ( resultSet.next() ){

            for (int colNum = 1; colNum <= columnCount; colNum++) {
                System.out.print(resultSet.getString(colNum) + "\t");
            }
            System.out.println();
        }
        resultSet.close();

    }
}
