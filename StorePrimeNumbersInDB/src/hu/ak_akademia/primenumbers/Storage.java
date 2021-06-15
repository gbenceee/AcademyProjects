package hu.ak_akademia.primenumbers;

import java.sql.SQLException;
import java.util.List;

public interface Storage {

	void deleteAll() throws SQLException;

	void save(List<Integer> numbers) throws SQLException;
}
