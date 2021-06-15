import java.util.ArrayList;
import java.util.List;

public class Sequence {
	public long countSequence(long number) {
		List<Long> sequence = new ArrayList<>();

		while (number > 1) {
			if (sequence.isEmpty()) {
				sequence.add(number);
				sequence.add(new Verify().generateSequenceNumber(number));
			} else {
				number = new Verify().generateSequenceNumber(sequence.get(sequence.size() - 1));
				sequence.add(number);
			}
		}

		return sequence.size();
	}
}
