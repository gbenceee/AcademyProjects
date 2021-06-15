
public class Office {

	public static void main(String[] args) {
		Dimensions dimensions = new Dimensions();
		dimensions.setWidthInMillimetres(221);
		dimensions.setHeightInMillimetres(340);
		dimensions.setDepthInMillimetres(430);

		CoffeeType[] supportedTypeOfCoffees = { CoffeeType.ESPRESSO, CoffeeType.DOUBLE_ESPRESSO, CoffeeType.LATTE_MACCHIATO, CoffeeType.LATTE };
		// CoffeeType[] supportedTypeOfCoffees = new CoffeeType[4];
		// supportedTypeOfCoffees[0] = CoffeeType.ESPRESSO;
		// supportedTypeOfCoffees[1] = CoffeeType.DOUBLE_ESPRESSO;
		// supportedTypeOfCoffees[2] = CoffeeType.LATTE_MACCHIATO;
		// supportedTypeOfCoffees[3] = CoffeeType.LATTE;

		CoffeeMachine coffeeMachine1 = new CoffeeMachine();
		coffeeMachine1.setBrand("Nespresso");
		coffeeMachine1.setSerialNumber("SDG435756DFGDFG1234");
		coffeeMachine1.setType(CoffeeMachineType.AUTOMATIC);
		coffeeMachine1.setWeightInKilogram(4.5);
		coffeeMachine1.setPriceInHUF(120_000);
		coffeeMachine1.setColor(CoffeeMachineColor.BLACK);
		coffeeMachine1.setDimensions(dimensions);
		coffeeMachine1.setWaterCapacityInLitre(1.8);
		coffeeMachine1.setBrewingCapacityInLitre(0.5);
		coffeeMachine1.setPowerConsumptionInWatts(1_450);
		coffeeMachine1.setCanProduceHotWater(true);
		coffeeMachine1.setSupportedTypeOfCoffees(supportedTypeOfCoffees);
		System.out.println(coffeeMachine1);

		CoffeeMachine coffeeMachine2 = new CoffeeMachine("Nespresso");
		System.out.println(coffeeMachine2);

		CoffeeMachine coffeeMachine3 = new CoffeeMachine("Nespresso", CoffeeMachineType.MANUAL, 2.2, 14_990, false);
		coffeeMachine3.setWeightInKilogram(150.0);
		coffeeMachine3.setPriceInHUF(100_000_001);
		System.out.println(coffeeMachine3);

		CoffeeMachine coffeeMachine4 = new CoffeeMachine(new Dimensions(340, 221, 430));
		System.out.println(coffeeMachine4);
	}

}
