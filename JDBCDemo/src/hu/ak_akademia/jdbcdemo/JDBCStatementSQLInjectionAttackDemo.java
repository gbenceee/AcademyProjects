package hu.ak_akademia.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCStatementSQLInjectionAttackDemo {

	public static void main(String[] args) throws SQLException {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Kérem, adjon meg egy név töredéket: ");
			String nameFragment = scan.nextLine();
			System.out.println("Adatbázis kapcsolat megnyitása...");
			try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB1", "webshop", "admin")) {
				String sql = "SELECT customer_id, last_name, first_name FROM customer WHERE last_name || ' ' || first_name LIKE '%" + nameFragment + "%'";
				try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
					preparedStatement.setInt(1, 4);
					try (ResultSet resultSet = preparedStatement.executeQuery(sql)) {
						while (resultSet.next()) {
							int id = resultSet.getInt("customer_id");
//						String id = resultSet.getString("customer_id"); így is működik
							String lastName = resultSet.getString("last_name");
							String firstName = resultSet.getString("first_name");

							System.out.format("%10d %10s %10s%n", id, lastName, firstName);
						}
					}
				}
			}
		}
	}

}