package ASDFramework.src.Strategy;

import ASDFramework.src.MysqlProxy.DBMysqlProxy;

import java.sql.Connection;

public class DBContext {

    private final DBStrategy dbStrategy;

    public DBContext(DBMysqlProxy dbStrategy) {
        this.dbStrategy = dbStrategy;
    }

    public Connection getCon() throws Exception {
        return dbStrategy.getCon();
    }

    public void closeCon(Connection con) throws Exception {
        dbStrategy.closeCon(con);
    }
}
