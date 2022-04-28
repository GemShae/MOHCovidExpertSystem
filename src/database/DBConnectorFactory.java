package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorFactory {
    private static Connection myConn = null;

    public static Connection getDatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mohexpertsystem?useSSL=false";

        try {
            if (myConn == null) {
                myConn = DriverManager.getConnection(url, "root", "");
            }
        }catch (SQLException ex) {
            throw new SQLException();
        }
        return myConn;
    }
}
