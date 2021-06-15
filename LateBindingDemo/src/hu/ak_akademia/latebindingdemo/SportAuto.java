package hu.ak_akademia.latebindingdemo;

public class SportAuto extends Auto {
	@Override
	void speedUp() {
		System.out.println("SportAuto gyorsít");
	}

	void slowDown() {
		System.out.println("SportAuto lassít");
	}
}
