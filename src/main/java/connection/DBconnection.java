package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	private static Connection con=null;
	
	

	public static Connection getConnection() {
		if(con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","sql123"); 
				System.out.print("connected");
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		return con;
	}
	

}
