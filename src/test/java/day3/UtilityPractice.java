package day3;

import utility.DB_Utility;


import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class UtilityPractice {

    public static void main(String[] args) throws SQLException {

        // TEST OUT ALL THE METHODS YOU HAVE CREATED SO FAR FOR PRACTICE
        DB_Utility.createConnection();

        ResultSet jobRS = DB_Utility.runQuery("SELECT * FROM JOBS");

        /**
         * Get the row count of the ResultSet
         * move the pointer to the last row and get the row number
         */
//        jobRS.last();
//        int rowCount = jobRS.getRow(); // getRow is getting the current row number
//        System.out.println("rowCount = " + rowCount);
        int rowCount = DB_Utility.getRowCount();
        System.out.println("rowCount = " + rowCount);

        int colCount = DB_Utility.getColumnCount();
        System.out.println("colCount = " + colCount);

        System.out.println("All Column names " + DB_Utility.getColumnNames());
        System.out.println("Row data at row 3 " + DB_Utility.getRowDataAsList(3));
        System.out.println("get cell value at row 2 col 4 "
                + DB_Utility.getColumnDataAtRow(2, 4));
        System.out.println("get cell value at row 2 col MIN_SALARY "
                + DB_Utility.getColumnDataAtRow(2, "MIN_SALARY"));

        System.out.println("3rd column value " + DB_Utility.getRowDataAsList(3));
        System.out.println("JOB_TITLE column value " + DB_Utility.getColumnDataAsList("JOB_TITLE"));

        System.out.println("-------\n");
        DB_Utility.displayAllData();

        Map<String, String> row1map = new LinkedHashMap<>(); // new hashMap<>();
        // JOB_ID , JOB_TITLE , MIN_SALARY , MAX_SALARY
        //AC_COUNT Public accountant 4200 9000
        row1map.put("JOB_ID", "AC_ACCOUNT");
        row1map.put("JOB_TITLE", " Public accountant");
        row1map.put("MIN_SALARY", "4200");
        row1map.put("MAX_SALARY", "9000");

        // now do above programmatically
        // create row 1 map like above programmatically
        // System.out.println("row1map = " + row1map);

        System.out.println("first row rowMap = " + DB_Utility.getRowMap(1));

        // if one row can be represented as one map object
        // what data structure is good to store 19 rows of data
        // List of Map

        // Get 2nd row and 4th row and save it into list of map as practice
        Map<String , String> row2Map = DB_Utility.getRowMap(2);
        Map<String , String> row4Map = DB_Utility.getRowMap(4);

        List<Map<String, String> > rowMapList = new ArrayList<>();
        rowMapList.add(row2Map);
        rowMapList.add(row4Map);

        System.out.println(rowMapList);





        DB_Utility.destroy();
    }
}
