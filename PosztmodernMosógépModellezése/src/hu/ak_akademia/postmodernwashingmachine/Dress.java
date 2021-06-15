package hu.ak_akademia.postmodernwashingmachine;

public abstract class Dress implements Washable {
	abstract boolean isColorful();

	abstract int getScaleOfDirtiness();

	abstract String getNameOfDress();

	abstract int getDurability();

	abstract void setDressTorned();

	abstract void decreaseDurability(int number);
}
