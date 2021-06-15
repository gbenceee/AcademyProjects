package hu.ak_akademia.primenumbers;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		Storage storage = new OracleXEDBStorage();
		storage.deleteAll();
		NumberGenerator numberGenerator = new PrimeNumberGenerator();
		List<Integer> primes = numberGenerator.generate(1_000_000);
		storage.save(primes);
		NumberLoader loader = new OracleXEDBLoader();
		List<Integer> numbersToPrint = loader.load();
		for (Integer numberToPrint : numbersToPrint) {
			System.out.println(numberToPrint);
		}
		System.out.println("Viszlát!");
	}

}
