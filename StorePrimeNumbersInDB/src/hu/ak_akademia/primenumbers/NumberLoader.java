package hu.ak_akademia.primenumbers;

import java.sql.SQLException;
import java.util.List;

public interface NumberLoader {
	List<Integer> load() throws SQLException;
}
