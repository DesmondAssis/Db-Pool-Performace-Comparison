package com.desmond.dbcp.cp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.desmond.dbcp.cp.util.DataSourceConstants;
import com.desmond.dbcp.cp.util.PropertyUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0ConnectionPool {
public static ComboPooledDataSource dataSource = null;
	
	public static void init() {
		dataSource = new ComboPooledDataSource();
		try {
			Properties pros = PropertyUtil.getProperties();
			dataSource.setDriverClass(pros.getProperty(DataSourceConstants.DB_DRIVER));
			
            dataSource.setJdbcUrl(pros.getProperty(DataSourceConstants.JDBC_URL));
            dataSource.setUser(pros.getProperty(DataSourceConstants.USER_NAME));
            dataSource.setPassword(pros.getProperty(DataSourceConstants.PASSWORD));
			
            dataSource.setMaxPoolSize(Integer.valueOf(pros.getProperty(DataSourceConstants.C3P0_MAX_POOL_SIZE)));
            dataSource.setMinPoolSize(Integer.valueOf(pros.getProperty(DataSourceConstants.C3P0_MIN_POOL_SIZE)));
            dataSource.setInitialPoolSize(Integer.valueOf(pros.getProperty(DataSourceConstants.C3P0_INITIAL_POOL_SIZE)));
			
	    	
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		if(dataSource == null) {			
			C3P0ConnectionPool.init();
		}
		
		return dataSource.getConnection();
	}
}
