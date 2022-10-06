package utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Utility_Recording {
    static ResultSet resultSet;

    public static void main(String[] args) {

        //param rowNum - row number we want to get data from
        // column index - we want to get the data from
        // returns: the data in String
    }

    public static String getColumnDataAtRow(int rowNum, int columnIndex) {

        String result = "";
        try {
            resultSet.absolute(rowNum);
            result = resultSet.getString(columnIndex);
            resultSet.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING CELL VALUE AT ROWNUM COLNUM" + e.getMessage());
        }
            return result;

    }
}