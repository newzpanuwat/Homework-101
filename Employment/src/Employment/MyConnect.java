package Employment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	// Create method for Connect with MYSQL Database
	// This method will return value to be Connection
	
	public static Connection getConnection(){
		try {
			// Call driver JDBC
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Return Connection to Database
			return DriverManager.getConnection("jdbc:mysql://localhost/Employment","root","");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		
		return null;
	}
}
