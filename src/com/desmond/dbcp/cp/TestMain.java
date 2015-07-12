package com.desmond.dbcp.cp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.time.StopWatch;

public class TestMain {

	public static void main(String[] args) throws Exception {
		int connType = 2;
		// single thread
		
//		testSingleThread(connType);
		
		// multiple thread
		testMultipleThread(connType);
	}
	
	public static void testSingleThread(int connType) throws Exception {
		int number = 1000000;
		new Thread(new ConnectionPoolAble(connType, number)).start();
	}
	
	public static void testMultipleThread(int connType) throws Exception {
		int threadCount = 500;
		int connNumber = 100;
		
		StopWatch sw = new StopWatch();
		
		sw.start();
		for(int i = 0; i < threadCount; i++) {
			new Thread(new ConnectionPoolAble(connType, connNumber)).start();
		}
		sw.stop();
		
		String type = "Proxool";
		switch (connType) {
		case 0:
			type = "BoneCP";
			break;

		case 1:
			type = "C3P0";
			break;

		case 2:
			type = "DBCP";
			break;

		default:
			type = "Proxool";
			break;
		}
		
		System.out.println("type:" + type + " BoneCP, number of get/release connect: " + 100 + ", time:"
		+ sw.getTime() + "ms");
	}
}