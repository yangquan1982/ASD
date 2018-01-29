package shopping.dao;


import shopping.util.ConfigurationHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection implements IDbConnection {

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(ConfigurationHelper.getConfiguration("CONNECTION_STRING"));
            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if(conn == null || conn.isClosed()) {
                this.open();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't open connection: " + e.getMessage());
        }

        return conn;
    }
}