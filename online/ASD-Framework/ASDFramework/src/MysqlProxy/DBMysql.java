package ASDFramework.src.MysqlProxy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBMysql implements DBInterface {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_xsxk";
    private String dbUserName = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.jdbc.Driver";

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
