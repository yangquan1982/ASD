package ASDFramework.src.Strategy;

import java.sql.Connection;

public interface DBStrategy {
    Connection getCon() throws Exception;

    void closeCon(Connection con) throws Exception;
}
