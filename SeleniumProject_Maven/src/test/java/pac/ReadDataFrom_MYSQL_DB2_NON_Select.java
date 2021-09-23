package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB2_NON_Select {
	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
Statement stat = con.createStatement();
String query = "insert into students_info (regno, firstname, middlename, lastname) values('6', 'shivi','sinha', 'sushmit')";
int result = stat.executeUpdate(query);
if(result==1) {
	System.out.println("user is created");
}else {
	System.out.println("user is not created");
}
con.close();
	}

}
