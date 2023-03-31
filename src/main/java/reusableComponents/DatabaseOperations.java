package reusableComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseOperations {
	
	public synchronized HashMap<String, String> getSqlResultInMap(String sqlQuery){
		HashMap<String, String> dataMap = new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qdpm_qa?serverTimezone=UTC","root","");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sqlQuery);
			ResultSetMetaData md = rs.getMetaData();
			while(rs.next()) {
				for(int i=1; i<=md.getColumnCount(); i++) {
					dataMap.put(md.getColumnName(i), rs.getString(i));
				}
			}
			System.out.println(dataMap);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dataMap;
		
	}

}
