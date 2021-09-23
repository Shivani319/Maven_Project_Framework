package com.crm.autodesk.GenericLibraries;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.cj.jdbc.Driver;


	public class DataBaseUtility {

		Connection con = null;
		Driver driverRef;
		/**
		 * @throws SQLException 
		 * 
		 */
		
		public void connectToDB() throws SQLException {
			
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","root");
			Statement stat =con.createStatement();
			String query = "select * from students_info";
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}
					
			
		}
		
		public void closeDb() throws Throwable {
			
			con.close();
				
		}
	}



