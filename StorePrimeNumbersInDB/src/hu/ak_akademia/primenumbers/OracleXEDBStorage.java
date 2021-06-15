package hu.ak_akademia.primenumbers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleXEDBStorage implements Storage {

	@Override
	public void deleteAll() throws SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB1", "prime_numbers", "admin")) {
			try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM prime_numbers")) {
				preparedStatement.executeUpdate();
				System.out.println("Minden rekord sikeresen törölve a prime_numbers nevű táblából.");
			}
		}
	}

	@Override
	public void save(List<Integer> numbers) throws SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB1", "prime_numbers", "admin")) {
			try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO prime_numbers (the_number) VALUES (?)")) {
				int counter = 0;
				for (Integer number : numbers) {
					preparedStatement.setInt(1, number);
					preparedStatement.executeUpdate();
					counter++;
					if (counter % 5_000 == 0) {
						System.out.format("%d / %d%n", counter, numbers.size());
					}
				}
				System.out.println("Minden rekord sikeresen beszúrva a prime_numbers nevű táblába.");
			}
		}
	}

}
