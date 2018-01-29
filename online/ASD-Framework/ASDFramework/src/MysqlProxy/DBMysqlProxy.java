package ASDFramework.src.MysqlProxy;

import java.sql.Connection;

public class DBMysqlProxy implements DBInterface {

    private final DBMysql dbMysql;

    public DBMysqlProxy() {
        dbMysql = new DBMysql();
    }

    @Override
    public Connection getCon() throws Exception {
        return dbMysql.getCon();
    }

    @Override
    public void closeCon(Connection con) throws Exception {
        dbMysql.closeCon(con);
    }
}
