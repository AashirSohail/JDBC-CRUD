import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class connect {

	static String url;
	static String username;
	static String password;
	static Connection returnConnection;
	static Statement stmt;
	
	connect(Properties p){
		
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");

		make(this);
		
	}
	//String url, String username, String password
	 void make(connect c) {
		
	
		try (Connection connection = DriverManager.getConnection(connect.url, connect.username, connect.password)) { 
		        System.out.println("Database connected!"); 
		        returnConnection = connection;
		       
				
		        //return connection;
		} catch (SQLException e) { 
		        throw new IllegalStateException("Cannot connect the database!", e); 
		}
		
	}
	 	public static Connection returnConnection() throws SQLException
		{  
			return  DriverManager.getConnection(url, username, password);
		}
		
		public static Statement returnStatement()
		{
			return stmt;
		}
		
		public void closeConnection() throws SQLException
		{
			stmt.close();
			returnConnection.close();
		}
	
}
