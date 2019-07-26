package myluntan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	 public static Connection getConnection(){ 
    	 Connection conn = null; 
    	 try { 
    		 
    		 Class.forName("com.mysql.jdbc.Driver"); 
    		 conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myluntan?characterEncoding=UTF-8", "root", "12345678"); 
    		 } catch (Exception e) { 
    			 e.printStackTrace(); 
    			 } 
    	 return conn; 
    	} 
    		 
      public static void closeConnection(Connection conn){ 
    	
    	  if(conn != null){ 
    		  try { 
    			  conn.close(); 
    			  
    			  } catch (SQLException e) {
    				  e.printStackTrace(); 
    				  }
    		  } 
    	  }
    	
    	  }


