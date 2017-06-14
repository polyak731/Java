package MySQL_Viewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private String driverName = "com.mysql.jdbc.Driver";
	private Connection con = null;
	private String username = "root";
	private String password = "root";
	private String URL = "jdbc:mysql://localhost:3306";
	
	public JDBCConnection(String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		this.password = password;
		this.username = username;
		
		
		Class.forName(driverName).newInstance();
		con = DriverManager.getConnection(URL, username, password);
		
		if(con!=null) System.out.println("Connection succesfull");
	}
	
	
}
