package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects";
	private static String USER = "projects";
	


 public static Connection  getConnection() { //connects to the url
	 String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD ); //url for site
	 System.out.println("Connecting with url=" + url);
	 
	try {
		Connection conn = DriverManager.getConnection(url); //creates a connection named conn using the driver manager and calling the get connection method on the url
		System.out.println("Successfully obtained connection!"); //prints if successful
		return conn; //returns the connection
	} catch (SQLException e) {
	throw new DbException(e);
	}
 }
}