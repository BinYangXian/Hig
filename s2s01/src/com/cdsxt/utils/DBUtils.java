package com.cdsxt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Object ...objects){
		
		if(objects!=null && objects.length>0){
			try{
				for(Object object:objects){
					if(object instanceof Statement){
						((Statement)object).close();
					}else if(object instanceof ResultSet){
						((ResultSet)object).close();
					}else if(object instanceof Connection){
						((Connection)object).close();
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
