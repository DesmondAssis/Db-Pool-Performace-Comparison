package com.desmond.dbcp.cp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtil {
	
	public static final Log log = LogFactory.getLog(PropertyUtil.class);
	
	public static Properties getProperties() {
		InputStream is = PropertyUtil.class.getResourceAsStream(DataSourceConstants.JDBC_FILE);
		Properties pros = new Properties();
		try {
			pros.load(is);
		} catch (IOException e) {
			log.error("Error occur when get properties: " + e.getMessage(), e);
		}
		
		return pros;
	}
}
