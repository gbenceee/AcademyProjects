package hu.ak_akademia.postmodernwashingmachine;

public class Pants extends Dress implements Washable {
	private int scaleOfDirtiness;
	private boolean isColorful;
	private String nameOfDress;
	private int durability = 100;
	private boolean isIroned;
	private boolean isTorned;
	private int howWet;

	public Pants(int scaleOfDirtiness, boolean isColorful, String nameOfDress, int howWet) {
		this.scaleOfDirtiness = scaleOfDirtiness;
		this.isColorful = isColorful;
		this.nameOfDress = nameOfDress;
		if (howWet < 0 || howWet > 100) {
			throw new IllegalArgumentException("A nedvesség mértéke 0 és 100 közötti egész szám lehet.");
		} else {
			this.howWet = howWet;
		}
	}

	public boolean isTorned() {
		return isTorned;
	}

	public void setTorned(boolean isTorned) {
		this.isTorned = isTorned;
	}

	@Override
	public void clean() {
		if (scaleOfDirtiness > 0) {
			scaleOfDirtiness -= 1;
		}
	}

	@Override
	public void dry() {
		howWet = 0;
	}

	@Override
	public void iron() {
		isIroned = true;
	}

	public boolean isColorful() {
		return isColorful;
	}

	public int getScaleOfDirtiness() {
		return scaleOfDirtiness;
	}

	@Override
	String getNameOfDress() {
		return nameOfDress;
	}

	public void decreaseDurability(int number) {
		if (durability > 0) {
			durability -= number;
		}
	}

	@Override
	public void setDressTorned() {
		isTorned = true;
	}

	@Override
	public int getDurability() {
		return durability;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("A ruha neve: ")
				.append(nameOfDress)

				.append(", koszossága: ")
				.append(scaleOfDirtiness)

				.append(", színes vagy fehér: ")
				.append(isColorful ? "színes" : "fehér")
				.append(", tartóssága: ")
				.append(durability)
				.append(", vasalva van-e: ")
				.append(isIroned ? "igen" : "nem")
				.append(", szakadt-e: ")
				.append(isTorned ? "igen" : "nem")
				.append(", nedvessége: ")
				.append(howWet);
		return builder.toString();
	}

}
