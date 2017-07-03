package Employment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	//สร้างเมธอดในการ connect กับ msyl
	
	//คืนค่าเป็นการconnect
	public static Connection getConnection()
	{
		try
		{
			//เรียกใช้ driver jdbc
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			//คืนค่าการConnect ไปยัง database Employment
			return DriverManager.getConnection("jdbc:mysql://localhost/Marketbooking","root","1234");
		}
		catch(ClassNotFoundException ex)
		{
			//print error
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			//print error
			ex.printStackTrace();
		}
		return null;  //เมื่อconnectไม่ได้จะคืนค่าnull
	}
}
