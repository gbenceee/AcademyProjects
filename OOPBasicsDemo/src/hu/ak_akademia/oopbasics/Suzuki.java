package hu.ak_akademia.oopbasics;

public class Suzuki extends Auto {

	@Override
	void accelerate() {
		System.out.println("Suzuki gyorsít");
	}

	void activateNitro() {
		System.out.println("Suzuki nitro aktiválva");
	}

}
