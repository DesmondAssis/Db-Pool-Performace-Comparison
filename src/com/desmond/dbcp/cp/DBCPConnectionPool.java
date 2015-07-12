package com.desmond.dbcp.cp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.desmond.dbcp.cp.util.PropertyUtil;

public class DBCPConnectionPool {
	private static BasicDataSource dataSource = null;   
	
	public static void init() {
		try {
			Properties pros = PropertyUtil.getProperties();
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(pros);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		if(dataSource == null) {			
			DBCPConnectionPool.init();
		}
		
		return dataSource.getConnection();
	}
}
