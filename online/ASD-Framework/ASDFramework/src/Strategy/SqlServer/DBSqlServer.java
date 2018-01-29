package ASDFramework.src.Strategy.SqlServer;

import ASDFramework.src.Strategy.DBStrategy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBSqlServer implements DBStrategy {
    private String dbUrl = "jdbc:sqlserver://localhost:3306/db_xsxk";
    private String dbUserName = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    @Override
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
