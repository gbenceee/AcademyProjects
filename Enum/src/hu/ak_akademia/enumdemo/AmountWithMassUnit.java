package hu.ak_akademia.enumdemo;

public class AmountWithMassUnit {
	private double amount;
	private MassUnit unit;

	public AmountWithMassUnit(double amount, MassUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public MassUnit getUnit() {
		return unit;
	}

	public void setUnit(MassUnit unit) {
		this.unit = unit;
	}

	public void convert(MassUnit newUnit) {
		double conversionRate = unit.convertTo(newUnit);
		amount *= conversionRate;
		unit = newUnit;
	}

	@Override
	public String toString() {
		return String.format("%.2f %s", amount, unit.getUnitName());
	}
}
