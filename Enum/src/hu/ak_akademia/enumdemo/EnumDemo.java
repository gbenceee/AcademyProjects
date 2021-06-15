package hu.ak_akademia.enumdemo;

public class EnumDemo {

	public static void main(String[] args) {
		// MassUnit -> String konvertálás
		MassUnit unit = MassUnit.GRAM;
		System.out.println(unit.getUnitName());
		System.out.println(unit.getUnitFullName());

		// String -> MassUnit konvertálás
		String userSpecifiedUnit = "dkg";
		MassUnit parsedUnit = MassUnit.parseFromUnit(userSpecifiedUnit);
		System.out.println(parsedUnit);

		// konvertálás
		System.out.println(MassUnit.GRAM.convertTo(MassUnit.MILLIGRAM));
		System.out.println(MassUnit.MILLIGRAM.convertTo(MassUnit.GRAM));
		System.out.println(MassUnit.GRAM.convertTo(MassUnit.KILOGRAM));
		System.out.println(MassUnit.MILLIGRAM.convertTo(MassUnit.TON));

		// példa szám és mértékegység együttesre
		AmountWithMassUnit amount = new AmountWithMassUnit(5, MassUnit.GRAM);
		System.out.println(amount);

		// érték átszámolása már mértékegységre
		amount.convert(MassUnit.MILLIGRAM);
		System.out.println(amount);
	}

}
