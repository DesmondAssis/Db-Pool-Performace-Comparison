package com.desmond.dbcp.cp;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

public class ProxoolConnectionPool {
	public static final Log log = LogFactory.getLog(ProxoolConnectionPool.class);
	private static Connection conn = null;

	static {
		init();
	}
	
	public static void init() {
		try {
			InputStream is = ProxoolConnectionPool.class.getResourceAsStream("/proxool.xml");
			try {
				JAXPConfigurator.configure(new InputStreamReader(is), false);
				
				log.info("Configuration file(proxool.xml) has been loaded !");
			} catch (Exception e) {
				log.error("Load Configuration failed ! " + e.getMessage(), e);
			} finally {
				try {
					is.close();
				} catch (Exception ex) {
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("proxool.connection");

		return conn;
	}
}
