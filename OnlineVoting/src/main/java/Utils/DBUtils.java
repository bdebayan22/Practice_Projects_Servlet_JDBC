package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;
	  public static Connection getConnection() throws SQLException
	  {
		  return cn;			
	  }
	  
	  public static void openConnection(String url,String username,String password) throws SQLException
	  {
				cn= DriverManager.getConnection(url, username,password);
				
	  }
}
