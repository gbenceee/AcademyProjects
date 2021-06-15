import java.util.Arrays;

public class CoffeeMachine {
	private String brand;
	private String serialNumber;
	private CoffeeMachineType type;
	private double weightInKilogram;
	private int priceInHUF;
	private CoffeeMachineColor color;
	private Dimensions dimensions;
	private double waterCapacityInLitre;
	private double brewingCapacityInLitre;
	private int powerConsumptionInWatts;
	private boolean canProduceHotWater;
	private CoffeeType[] supportedTypeOfCoffees;
	private int waterAmountMinInMiliLitre;
	private int waterAmountMaxInMiliLitre;
	private int waterAmountInMiliLitre;
	private int coffeeAmountMinInGram;
	private int coffeeAmountMaxInGram;
	private int coffeeAmountInGram;
	private CoffeeMachineState state;
	private int currentWaterLevelInMiliLitre;

	public CoffeeMachine() {
	}

	public CoffeeMachine(String brand) {
		this.brand = brand;
		this.color = CoffeeMachineColor.WHITE;
	}

	// nem lehet két ugyanolyan leírójú konstruktor (ugyanolyan paraméterlistájú)
	// public CoffeeMachine(String serialNumber) {
	// this.serialNumber = serialNumber;
	// this.color = CoffeeMachineColor.WHITE;
	// }

	public CoffeeMachine(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public CoffeeMachine(String brand, CoffeeMachineType type, double weightInKilogram, int priceInHUF, boolean canProduceHotWater) {
		this.brand = brand;
		this.type = type;
		this.weightInKilogram = weightInKilogram;
		checkWeightValid(weightInKilogram);
		this.priceInHUF = priceInHUF;
		checkPrice(priceInHUF);
		this.canProduceHotWater = canProduceHotWater;
	}

	private void checkPrice(int priceInHUF) {
		if (priceInHUF <= 0 || priceInHUF > 10_000_000) {
			System.out.println("Az ár csak 0 és 10 000 000 közötti lehet.");
		}
		if (priceInHUF % 5 != 0) {
			System.out.println("Az ár csak 0-ra vagy 5-re végződhet.");
		}
	}

	private void checkWeightValid(double weightInKilogram) {
		if (weightInKilogram <= 0.0 || weightInKilogram > 100.0) {
			System.out.println("A tömeg csak 0 és 100 közötti lehet.");
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public CoffeeMachineType getType() {
		return type;
	}

	public void setType(CoffeeMachineType type) {
		this.type = type;
	}

	public double getWeightInKilogram() {
		return weightInKilogram;
	}

	public void setWeightInKilogram(double weightInKilogram) {
		this.weightInKilogram = weightInKilogram;
		checkWeightValid(weightInKilogram);
	}

	public int getPriceInHUF() {
		return priceInHUF;
	}

	public void setPriceInHUF(int priceInHUF) {
		this.priceInHUF = priceInHUF;
		checkPrice(priceInHUF);
	}

	public CoffeeMachineColor getColor() {
		return color;
	}

	public void setColor(CoffeeMachineColor color) {
		this.color = color;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public double getWaterCapacityInLitre() {
		return waterCapacityInLitre;
	}

	public void setWaterCapacityInLitre(double waterCapacityInLitre) {
		this.waterCapacityInLitre = waterCapacityInLitre;
	}

	public double getBrewingCapacityInLitre() {
		return brewingCapacityInLitre;
	}

	public void setBrewingCapacityInLitre(double brewingCapacityInLitre) {
		this.brewingCapacityInLitre = brewingCapacityInLitre;
	}

	public int getPowerConsumptionInWatts() {
		return powerConsumptionInWatts;
	}

	public void setPowerConsumptionInWatts(int powerConsumptionInWatts) {
		this.powerConsumptionInWatts = powerConsumptionInWatts;
	}

	public boolean isCanProduceHotWater() {
		return canProduceHotWater;
	}

	public void setCanProduceHotWater(boolean canProduceHotWater) {
		this.canProduceHotWater = canProduceHotWater;
	}

	public CoffeeType[] getSupportedTypeOfCoffees() {
		return supportedTypeOfCoffees;
	}

	public void setSupportedTypeOfCoffees(CoffeeType[] supportedTypeOfCoffees) {
		this.supportedTypeOfCoffees = supportedTypeOfCoffees;
	}

	public int getWaterAmountMinInMiliLitre() {
		return waterAmountMinInMiliLitre;
	}

	public void setWaterAmountMinInMiliLitre(int waterAmountMinInMiliLitre) {
		this.waterAmountMinInMiliLitre = waterAmountMinInMiliLitre;
	}

	public int getWaterAmountMaxInMiliLitre() {
		return waterAmountMaxInMiliLitre;
	}

	public void setWaterAmountMaxInMiliLitre(int waterAmountMaxInMiliLitre) {
		this.waterAmountMaxInMiliLitre = waterAmountMaxInMiliLitre;
	}

	public int getWaterAmountInMiliLitre() {
		return waterAmountInMiliLitre;
	}

	public void setWaterAmountInMiliLitre(int waterAmountInMiliLitre) {
		this.waterAmountInMiliLitre = waterAmountInMiliLitre;
	}

	public int getCoffeeAmountMinInGram() {
		return coffeeAmountMinInGram;
	}

	public void setCoffeeAmountMinInGram(int coffeeAmountMinInGram) {
		this.coffeeAmountMinInGram = coffeeAmountMinInGram;
	}

	public int getCoffeeAmountMaxInGram() {
		return coffeeAmountMaxInGram;
	}

	public void setCoffeeAmountMaxInGram(int coffeeAmountMaxInGram) {
		this.coffeeAmountMaxInGram = coffeeAmountMaxInGram;
	}

	public int getCoffeeAmountInGram() {
		return coffeeAmountInGram;
	}

	public void setCoffeeAmountInGram(int coffeeAmountInGram) {
		this.coffeeAmountInGram = coffeeAmountInGram;
	}

	public CoffeeMachineState getState() {
		return state;
	}

	public void setState(CoffeeMachineState state) {
		this.state = state;
	}

	public Coffee brew(CoffeeType coffeeType) {
		Coffee coffee = new Coffee();
		coffee.setType(coffeeType);
		if (currentWaterLevelInMiliLitre < waterAmountInMiliLitre) {
			System.out.println("Nincs elég víz a tartályban a kávé lefőzéséhez.");
		}
		coffee.setAmountInMiliLitre(Math.min(waterAmountInMiliLitre, currentWaterLevelInMiliLitre));
		currentWaterLevelInMiliLitre = Math.max(0, currentWaterLevelInMiliLitre - waterAmountInMiliLitre);
		coffee.setStrength(calculateStrength());
		coffee.setContainsCaffeine(true);
		return coffee;
	}

	private CoffeeStrength calculateStrength() {
		if (coffeeAmountInGram < 5) {
			return CoffeeStrength.VERY_WEAK;
		} else if (coffeeAmountInGram < 10) {
			return CoffeeStrength.WEAK;
		} else if (coffeeAmountInGram < 15) {
			return CoffeeStrength.MEDIUM;
		} else if (coffeeAmountInGram < 20) {
			return CoffeeStrength.STRONG;
		} else {
			return CoffeeStrength.VERY_STRONG;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine [brand=");
		builder.append(brand);
		builder.append(", serialNumber=");
		builder.append(serialNumber);
		builder.append(", type=");
		builder.append(type);
		builder.append(", weightInKilogram=");
		builder.append(weightInKilogram);
		builder.append(", priceInHUF=");
		builder.append(priceInHUF);
		builder.append(", color=");
		builder.append(color);
		builder.append(", dimensions=");
		builder.append(dimensions);
		builder.append(", waterCapacityInLitre=");
		builder.append(waterCapacityInLitre);
		builder.append(", brewingCapacityInLitre=");
		builder.append(brewingCapacityInLitre);
		builder.append(", powerConsumptionInWatts=");
		builder.append(powerConsumptionInWatts);
		builder.append(", canProduceHotWater=");
		builder.append(canProduceHotWater);
		builder.append(", supportedTypeOfCoffees=");
		builder.append(Arrays.toString(supportedTypeOfCoffees));
		builder.append(", waterAmountMinInMiliLitre=");
		builder.append(waterAmountMinInMiliLitre);
		builder.append(", waterAmountMaxInMiliLitre=");
		builder.append(waterAmountMaxInMiliLitre);
		builder.append(", waterAmountInMiliLitre=");
		builder.append(waterAmountInMiliLitre);
		builder.append(", coffeeAmountMinInGram=");
		builder.append(coffeeAmountMinInGram);
		builder.append(", coffeeAmountMaxInGram=");
		builder.append(coffeeAmountMaxInGram);
		builder.append(", coffeeAmountInGram=");
		builder.append(coffeeAmountInGram);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}

}
