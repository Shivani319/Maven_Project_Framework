package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromMySqlDB {
public static void main(String[] args) throws Throwable {
Driver driverRef = new Driver();
DriverManager.registerDriver(driverRef);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	Statement stat = con.createStatement();
	String query = "Select * from students_info";
	ResultSet result = stat.executeQuery(query);
	while (result.next()) {
	System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
	
		
	}
	con.close();
		
		
	}
}
