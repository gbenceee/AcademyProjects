package hu.ak_akademia.oopbasics;

public class Main {

	public static void main(String[] args) {
		Auto a = new Auto();
		Suzuki b = new Suzuki();

		a.accelerate();
		a.decelrate();

		b.accelerate();
		b.decelrate();
		b.activateNitro();

		a = b;

		a.accelerate();
		a.decelrate();
		
		Object c = b;
		((Suzuki) c).accelerate();
		((Suzuki) c).decelrate();
		((Suzuki) c).activateNitro();

	}

}
