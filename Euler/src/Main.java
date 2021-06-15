import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// List<Integer> counter = new ArrayList<>();

		Map<Long, Long> result = new HashMap<>();

		for (long number2 = 0; number2 <= 1_000_000; number2++) {

			result.put(number2, new Sequence().countSequence(number2));

		}

//		 int maxPiece = Collections.max(result.values());

		// System.out.println(maxPiece);
		long maxPiece = 0;
		long key = 0;

		for (Map.Entry<Long, Long> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());

			if (entry.getValue() > maxPiece) {
				maxPiece = entry.getValue();
				key = entry.getKey();

			}
		}

		System.out.println(key);
	}

}
