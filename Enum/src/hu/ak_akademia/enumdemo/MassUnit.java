package hu.ak_akademia.enumdemo;

public enum MassUnit {
	TON("t", "tonna", 1_000_000), KILOGRAM("kg", "kilogramm", 1_000), DEKAGRAM("dkg", "dekagramm", 10), GRAM("g", "gramm"), MILLIGRAM("mg", "milligramm", 0.001);

	private final String unitName;
	private final String unitFullName;
	private final double conversionRate;

	private MassUnit(String unitName, String unitFullName) {
		this(unitName, unitFullName, 1.0);
	}

	private MassUnit(String unitName, String unitFullName, double conversionRate) {
		this.unitName = unitName;
		this.unitFullName = unitFullName;
		this.conversionRate = conversionRate;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getUnitFullName() {
		return unitFullName;
	}

	public double convertTo(MassUnit destinationMassUnit) {
		return conversionRate / destinationMassUnit.conversionRate;
	}

	public static MassUnit parseFromUnit(String unitAsString) {
		for (MassUnit massUnit : values()) {
			if (massUnit.getUnitName()
					.equals(unitAsString)) {
				return massUnit;
			}
		}
		throw new IllegalArgumentException("Érvénytelen tömeg mértékegység.");
	}

}
