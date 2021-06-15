
public class FormattingDemo {

	public static void main(String[] args) {
		//egész számok formázása
		int total = 50;
		int current = 15;
		System.out.format("%4d elem elkészült a(z) %4d elemből%n", 3, 9);
		System.out.format("%4d elem elkészült a(z) %4d elemből%n", current, total);
		System.out.format("%4d elem elkészült a(z) %4d elemből%n", 245, 500);
		System.out.format("%4d elem elkészült a(z) %4d elemből%n", 3658, 5000);
		//%n sortörés
		System.out.println("-------------------------------------------");
		//dátum formázás
		System.out.format("%02d:%02d:%02d%n", 2, 7, 0);
		System.out.format("%02d:%02d:%02d%n", 1, 55, 4);
		System.out.format("%02d:%02d:%02d%n", 0, 0, 0);
		System.out.format("%02d:%02d:%02d%n", 23, 59, 59);
		System.out.println("-------------------------------------------");
		
		//valós számok formázása
		double pi = Math.PI;
		pi = pi * 1_000_000.0;
		System.out.println(pi);
		System.out.format("A pi értéke: %,.2f%n", pi);
		//%20.4f |4 tizedeshely, max 20 szám|
		//%,.2f |ezres, helyek tagolása könnyebb olvashatóságért, 2 tizedeshely
		
		System.out.println("-------------------------------------------");
		//szövegek formázása
		String text = "másolása";
		System.out.format("A fájlok %s megtörtént.%n", text);
		text = "áthelyezése";
		System.out.format("A fájlok %s megtörtént.%n", text);
		
		System.out.println("-------------------------------------------");
		//String formázása
		String formattedText = String.format("%4d. %02d. %02d.", 2019, 9, 15);
		//...
		System.out.println(formattedText);
		
		
		
		
		
		
		
		
		
		
		

	}

}
