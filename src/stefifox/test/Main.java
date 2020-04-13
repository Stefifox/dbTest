package stefifox.test;

import java.sql.SQLException;
import java.util.HashMap;

public class Main {

public static String connectorUrl = "jdbc:mysql://localhost:3306/provaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Replace "provaDB" with your DB name and UTC with your Timezone
public static String tableName = "event"; // Replace with your table name

public static String User = "root"; // Replace with your DB User
public static String Pass = "root"; // Replace with your DB user password 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> tabella = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
		    // gestione dell'eccezione
			e.printStackTrace();
		}
		
		try {
			System.out.println(DBConnection.getLastLineById());
			DBConnection.addRow("Pasquetta", "Si Mangia");
			System.out.println(DBConnection.getLineById(DBConnection.getLastId()));
			//Print all map
			tabella = DBConnection.getAll();
			for (int key : tabella.keySet()) {
			    System.out.println(tabella.get(key));
			    System.out.println(" --- ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
