package stefifox.test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DBConnection {

	public static int getLastId() throws SQLException {
		
		int id = 0; 
		
		Connection connection = DriverManager.getConnection(Main.Connection, Main.User, Main.Pass );
		Statement stm = connection.createStatement();
		ResultSet rs=stm.executeQuery("SELECT id FROM " + Main.tableName);
		
		while(rs.next()) {
			id=rs.getInt(1);
		}
		
		stm.close();
		
		return id;
		
		
	}
	
	public static void addRow(String event_name, String description) throws SQLException {
		

		Connection connection = DriverManager.getConnection(Main.Connection, Main.User, Main.Pass );
		PreparedStatement prepared = connection.prepareStatement("INSERT INTO " + Main.tableName + " (id, data, event_name, description) VALUES (?,?,?,?)");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String data = simpleDateFormat.format(calendar.getTime());
		
		prepared.setInt(1, getLastId() + 1);
		prepared.setString(2, data);
		prepared.setString(3, event_name);
		prepared.setString(4, description);
		prepared.executeUpdate();
		
		
	}
	
	public static String getLastLineById() throws SQLException {
		
		Connection connection = DriverManager.getConnection(Main.Connection, Main.User, Main.Pass );
		Statement stm = connection.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM " + Main.tableName + " WHERE id = " + getLastId());
		
		rs.next();
		return rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
		
		
	}
	
	public static String getLineById(int id) throws SQLException {
		
		Connection connection = DriverManager.getConnection(Main.Connection, Main.User, Main.Pass );
		Statement stm = connection.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM " + Main.tableName + " WHERE id = " + id);
		
		rs.next();
		return rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
		
		
	}
	
	
	public static HashMap<Integer, String> getAll() throws SQLException{
		
		Connection connection = DriverManager.getConnection(Main.Connection, Main.User, Main.Pass );
		Statement stm = connection.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM " + Main.tableName);
		
		HashMap<Integer, String> temp = new HashMap<>();
		
		while(rs.next()) {
			temp.put(rs.getInt(1), rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
		}
		stm.close();
		return temp;
		
		
	}
	
}
