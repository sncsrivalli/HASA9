package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataInDatabase {

	public static void main(String[] args) throws SQLException {
		// Step 1: Create an instance for Driver
		// Driver should be imported from com.mysql.cj.jdbc.Driver
		// new Driver() throws SQLException
		Driver dbDriver = new Driver();

		// Step 2: Register to the dbDriver
		// DriverManager is in java.sql package
		DriverManager.registerDriver(dbDriver);

		// Step 3: Establish database connection
		// Connection should be imported from java.sql package
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hasa9", "root", "root");

		// Step 4: Create statement
		// Statement should be imported from java.sql package
		Statement statement = connect.createStatement();

		// Step 5: Execute query to fetch data
		int result = statement.executeUpdate(" insert into students(id,name,address) values(105,'Efg','Patna'),(106,'Ghi','Kochi'),(107,'Hij','Chennai'),(108,'Ijk','Delhi')");

		System.out.println(result+ " rows updated");
		

		// Step 6: Close database
		connect.close();

	}

}
