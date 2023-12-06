package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class MyJdbc {
	
	public static void main(String[] args) {
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_schema", "root", "Vishwesh86");
			Statement statment = connection.createStatement();
			
			ResultSet resultSet = statment.executeQuery("select * from user_schema.user_table");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("username"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
 