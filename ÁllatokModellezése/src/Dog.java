
public class Dog extends Animal {

	@Override
	public void eat() {
		System.out.println("A kutya eszik.");
	}

	@Override
	public void makeSound() {
		System.out.println("Vau");
	}

	@Override
	public void move() {
		System.out.println("A kutya fut.");
	}

}
