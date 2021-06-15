
public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[")
				.append(x)
				.append(", ")
				.append(y)
				.append("]");
		return builder.toString();
	}

}
