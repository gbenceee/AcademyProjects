
public class Main {

	public static void main(String[] args) {
		//input
		String inputString = "bence";
		//output
		String outputString = "";
		for (int i = inputString.length() - 1; i >= 0; i--) {
			outputString += inputString.charAt(i);
			//1. outputString = e
			//2. outputString = ec
			//3. outputString = ecn
			//4. outputString = ecne
			//5. outputString = ecneb
			
		}
		System.out.println(outputString);
		System.out.println("Program vége");
		
		
	}

}
