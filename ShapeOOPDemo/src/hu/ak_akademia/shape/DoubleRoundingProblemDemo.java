package hu.ak_akademia.shape;

import java.math.BigDecimal;

public class DoubleRoundingProblemDemo {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("0.4");
		BigDecimal b = new BigDecimal("0.1");
		BigDecimal c = a.subtract(b);
		System.out.println(c);
		double d = 0.4 - 0.1;
		System.out.println("d: " + d);
		double e = 0.3;
		System.out.println("e: " + e);
		System.out.println(d == e);
		System.out.println(Double.compare(d, e));
	}

}