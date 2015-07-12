package com.desmond.dbcp.cp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolAble implements Runnable {
	private int connType;
	private int connNumer;
	private Connection conn;

	public ConnectionPoolAble(int connType, int connNumber) {
		this.connType = connType;
		this.connNumer = connNumber;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < connNumer; i++) {
			try {
				switch (connType) {
				case 0:
					conn = BoneCPConnectionPool.getConnection();
					break;

				case 1:
					conn = C3P0ConnectionPool.getConnection();
					break;

				case 2:
					conn = DBCPConnectionPool.getConnection();
					break;

				default:
					conn = ProxoolConnectionPool.getConnection();
					break;
				}

				if (conn != null) {
					/*Statement statement = conn.createStatement();
					ResultSet rs = statement
							.executeQuery("select * from user where id=1");
					while (rs.next()) {
						String username = rs.getString(2);
						if(!username.equals("Desmond Li")) {
							throw new Exception("Name is incorrect!");
						}
					}
					rs.close();
					statement.close();*/
					Thread.sleep(10); // to simulate work being done with the connection.
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();

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

		System.out.println("type: " + type + ", number of get/release connect: " + this.connNumer + ", time:"
				+ (endTime - startTime) + "ms");

	}

}
