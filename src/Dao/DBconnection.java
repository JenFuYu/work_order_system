package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {

	public static void main(String[] args) {
		System.out.println(DBconnection.getDB());
	}
	
	public static Connection getDB() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/work_order";
		String user = "root";
		String password ="1234";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"
					+ "");
			conn = DriverManager.getConnection(url,user,password);
			//PreparedStatement ps = conn.prepareStatement(SQL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}


}
