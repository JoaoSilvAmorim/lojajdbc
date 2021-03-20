package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {

	private final static  String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static  String URL = "jdbc:mysql://localhost:3306/dados?useTimezone=true&serverTimezone=UTC";
	private final static  String USER = "root";
	private final static  String PASS = "12345678";

	public static Connection getConnection() {
		try {

			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão!!!", e);
		}

	}

	
	
	public static void closeConnection(Connection con) {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		}

	}

	
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {

		closeConnection(con);

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {

			throw new RuntimeException("Erro!!!", e);
		}

	}
	
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro!!!", e);
		}
	}
	
	

}