
public class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("A macska eszik.");
	}

	@Override
	public void drink() {
		System.out.println("A macska iszik.");
	}

	@Override
	public void makeSound() {
		System.out.println("Miau");
	}

	@Override
	public void move() {
		System.out.println("Az állat mozog.");
	}

	@Override
	public void sleep(int number) {
		System.out.println("Az macska alszik " + number + " percig.");
	}

}
