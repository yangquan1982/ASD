package com.java1234.util;

import ASDFramework.src.MysqlProxy.DBMysqlProxy;
import ASDFramework.src.Singleton.IUtil;
import ASDFramework.src.Strategy.DBContext;

import java.sql.Connection;

public class DBUtil implements IUtil {
	private DBUtil instance = null;
	@Override
	public IUtil getInstance() {
		if (instance != null) return instance;
		return new DBUtil();
	}

	private final DBContext dbMysql;

	public DBUtil() {
		dbMysql = new DBContext(new DBMysqlProxy());
	}

	public Connection getCon() throws Exception {
		return dbMysql.getCon();
	}

	public void closeCon(Connection con) throws Exception {
		dbMysql.closeCon(con);
	}
}
