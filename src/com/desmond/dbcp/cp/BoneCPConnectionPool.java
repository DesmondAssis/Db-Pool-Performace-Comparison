package com.desmond.dbcp.cp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.desmond.dbcp.cp.util.DataSourceConstants;
import com.desmond.dbcp.cp.util.PropertyUtil;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class BoneCPConnectionPool {
	private static BoneCP connectionPool = null;
	static {
		BoneCPConnectionPool.init();
	}
	
	public static void init() {
		try {
			Properties pros = PropertyUtil.getProperties();
			BoneCPConfig config = new BoneCPConfig();
			Class.forName(pros.getProperty(DataSourceConstants.DB_DRIVER));
			config.setJdbcUrl(pros.getProperty(DataSourceConstants.JDBC_URL));
			config.setUsername(pros.getProperty(DataSourceConstants.USER_NAME));
			config.setPassword(pros.getProperty(DataSourceConstants.PASSWORD));
			
			config.setMinConnectionsPerPartition(Integer.valueOf(pros.getProperty(DataSourceConstants.BONE_CP_MIN_CONNECTION_PER_PARTIITION)));
	    	config.setMaxConnectionsPerPartition(Integer.valueOf(pros.getProperty(DataSourceConstants.BONE_CP_MAX_CONNECTION_PER_PARTITION)));
	    	config.setPartitionCount(Integer.valueOf(pros.getProperty(DataSourceConstants.BONE_CP_PARTITION)));
			config.setAcquireIncrement(5);
			config.setReleaseHelperThreads(5);
			
	    	connectionPool = new BoneCP(config);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		
		return connectionPool.getConnection();
	}
}
