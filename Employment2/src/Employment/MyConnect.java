package Employment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	//���ҧ���ʹ㹡�� connect �Ѻ msyl
	
	//�׹����繡��connect
	public static Connection getConnection()
	{
		try
		{
			//���¡�� driver jdbc
			Class.forName(com.mysql.jdbc.Driver.class.getName());
			//�׹��ҡ��Connect ��ѧ database Employment
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
		return null;  //�����connect�����Ф׹���null
	}
}
