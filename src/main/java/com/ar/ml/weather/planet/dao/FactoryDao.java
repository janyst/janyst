package com.ar.ml.weather.planet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDao {
	private Connection crunchifyConn = null;
	private PreparedStatement crunchifyPrepareStat = null;
	
	public void makeJDBCConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.crunchifyConn = DriverManager.getConnection("jdbc:mysql:database-weather.cp02rueziard.us-east-1.rds.amazonaws.com:3306"
					+ "/database-weather","admin","admin123");
			this.getDataFromDB();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	private void getDataFromDB() {
		ResultSet rs = null;
		try {
			String getQueryStatement = "SELECT * FROM `SUMMARY-WEATHER`.SUMMARY_WEATHER;"; 
			this.crunchifyPrepareStat = crunchifyConn.prepareStatement(getQueryStatement);
 			rs = crunchifyPrepareStat.executeQuery();
 			while (rs.next()) {
				System.out.println("janyst tiene valor.");			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
