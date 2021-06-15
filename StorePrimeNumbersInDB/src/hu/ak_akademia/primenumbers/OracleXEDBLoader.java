package hu.ak_akademia.primenumbers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleXEDBLoader implements NumberLoader {

	@Override
	public List<Integer> load() throws SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB1", "prime_numbers", "admin")) {
			try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT the_number FROM prime_numbers ORDER BY the_number DESC")) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					List<Integer> primes = new ArrayList<>();
					while (resultSet.next()) {
						int prime = resultSet.getInt("the_number");
						primes.add(prime);
					}
					return primes;
				}
			}
		}
	}

}