
public class SaveResultIntoArray {

	public static void main(String[] args) {
		String[] monthlyConsumptionName = { "Havi vízfogyasztás (m3) - Monthly water consumption (m3)", "Havi gázfogyasztás (m3)- Monthly gas consumption (m3)",
				"Havi villanyfogyasztás (kWh)- Monthly electricity consumption (kWh)" };
		double[] consumptionData = { 200, 50, 100 };
		double[] monthlyConsumptionsInPound = { 100, 25, 50 };
		double[] monthlyConsumptionsInForint = { 2000, 500, 1000 };
		String[] data = new String[monthlyConsumptionName.length];
		data = saveResultIntoArray(monthlyConsumptionName, consumptionData, monthlyConsumptionsInForint, monthlyConsumptionsInPound);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

	}

	static String[] saveResultIntoArray(String[] monthlyConsumptionName, double[] consumptionData, double[] monthlyConsumptionsInForint, double[] monthlyConsumptionsInPound) {
		String[] result = new String[monthlyConsumptionName.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = monthlyConsumptionName[i] + ": " + Double.toString(consumptionData[i]) + " m3 " + Double.toString(monthlyConsumptionsInForint[i]) + " HUF "
					+ Double.toString(monthlyConsumptionsInPound[i]) + " GBP";

		}
		return result;

	}
}
