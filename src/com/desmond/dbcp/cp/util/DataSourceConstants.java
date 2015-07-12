package com.desmond.dbcp.cp.util;

public interface DataSourceConstants {
	// common
	String DB_DRIVER = "driverClassName";
	String JDBC_URL = "jdbc.url";
	String USER_NAME = "username";
	String PASSWORD = "password";
	
	// Bonecp
	String BONE_CP_MIN_CONNECTION_PER_PARTIITION = "minConnectionsPerPartition";
	String BONE_CP_MAX_CONNECTION_PER_PARTITION = "maxConnectionsPerPartition";
	String BONE_CP_PARTITION = "partitionCount";
	
	// DBCP
	String DBCP_MAX_ACTIVE = "maxActive";
	String DBCP_MAX_IDLE = "maxIdle";
	String DBCP_MIN_IDLE = "minIdle";
	String DBCP_INITIAL_SIZE = "initialSize";
	
	// C3P0
	String C3P0_MAX_POOL_SIZE = "maxPoolSize";
	String C3P0_MIN_POOL_SIZE = "minPoolSize";
	String C3P0_INITIAL_POOL_SIZE = "initialPoolSize";
	
	String JDBC_FILE = "/jdbc_connection.properties";
}
