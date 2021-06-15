
public enum CoffeeStrength {
	VERY_WEAK("Nagyon gyenge"), WEAK("Gyenge"), MEDIUM("Közepes"), STRONG("Erős"), VERY_STRONG("Nagyon erős");

	private String description;

	private CoffeeStrength(String description) {
		this.description = description;
	}

	private String getDescription() {
		return description;
	}
}
