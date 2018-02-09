package shopping.dao;

import java.sql.Connection;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public interface IDbConnection {
    boolean open();

    void close();

    Connection getConnection();
}
