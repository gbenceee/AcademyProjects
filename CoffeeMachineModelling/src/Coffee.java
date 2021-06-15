
public class Coffee {

	private CoffeeType type;
	private int amountInMiliLitre;
	private CoffeeStrength strength;
	private boolean containsCaffeine;
	private int sugarAmountInGram;
	private int milkAmountInMiliLitre;

	public Coffee(CoffeeType type, int amountInMiliLitre, CoffeeStrength strength, boolean containsCaffeine, int sugarAmountInGram, int milkAmountInMiliLitre) {
		this.type = type;
		this.amountInMiliLitre = amountInMiliLitre;
		this.strength = strength;
		this.containsCaffeine = containsCaffeine;
		this.sugarAmountInGram = sugarAmountInGram;
		this.milkAmountInMiliLitre = milkAmountInMiliLitre;
	}

	public Coffee() {
	}

	public CoffeeType getType() {
		return type;
	}

	public void setType(CoffeeType type) {
		this.type = type;
	}

	public int getAmountInMiliLitre() {
		return amountInMiliLitre;
	}

	public void setAmountInMiliLitre(int amountInMiliLitre) {
		this.amountInMiliLitre = amountInMiliLitre;
	}

	public CoffeeStrength getStrength() {
		return strength;
	}

	public void setStrength(CoffeeStrength strength) {
		this.strength = strength;
	}

	public boolean isContainsCaffeine() {
		return containsCaffeine;
	}

	public void setContainsCaffeine(boolean containsCaffeine) {
		this.containsCaffeine = containsCaffeine;
	}

	public int getSugarAmountInGram() {
		return sugarAmountInGram;
	}

	public void setSugarAmountInGram(int sugarAmountInGram) {
		this.sugarAmountInGram = sugarAmountInGram;
	}

	public int getMilkAmountInMiliLitre() {
		return milkAmountInMiliLitre;
	}

	public void setMilkAmountInMiliLitre(int milkAmountInMiliLitre) {
		this.milkAmountInMiliLitre = milkAmountInMiliLitre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coffee [type=");
		builder.append(type);
		builder.append(", amountInMiliLitre=");
		builder.append(amountInMiliLitre);
		builder.append(", strength=");
		builder.append(strength);
		builder.append(", containsCaffeine=");
		builder.append(containsCaffeine);
		builder.append(", sugarAmountInGram=");
		builder.append(sugarAmountInGram);
		builder.append(", milkAmountInMiliLitre=");
		builder.append(milkAmountInMiliLitre);
		builder.append("]");
		return builder.toString();
	}
}
