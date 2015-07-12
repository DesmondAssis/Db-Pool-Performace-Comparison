package com.desmond.dbcp.cp.test.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

import com.desmond.dbcp.cp.util.DataSourceConstants;
import com.desmond.dbcp.cp.util.PropertyUtil;

public class PropertyUtilTest {
	
	@Test
	public void TestGetProperties() {
		Properties pros = PropertyUtil.getProperties();
		
		assertEquals(pros.get(DataSourceConstants.DB_DRIVER), "com.mysql.jdbc.Driver");
		assertEquals(pros.get(DataSourceConstants.USER_NAME), "root");
		assertEquals(pros.get(DataSourceConstants.BONE_CP_MAX_CONNECTION_PER_PARTITION), "200");
		assertEquals(pros.get("not-exist-property"), null);
	}

}
