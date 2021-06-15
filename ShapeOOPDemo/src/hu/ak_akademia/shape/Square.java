package hu.ak_akademia.shape;

public class Square extends Rectangle {

	public Square(double a) {
		super(a, a);
	}

	public void draw() {
		System.out.println("***");
		System.out.println("***");
		System.out.println("***");
	}

}