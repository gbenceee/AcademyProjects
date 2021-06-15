package hu.ak_akademia.queuing;

public abstract class Person implements PersonPreparator {
	private String name;
	private int age;
	private int checkOutTime;

	public Person(String name, int age, int seconds) {
		this.name = name;
		this.age = age;
		this.checkOutTime = seconds;
	}

	@Override
	public int getCheckOutTime() {
		return checkOutTime;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void checkOut() {
		try {
			Thread.sleep(checkOutTime * 1_000L);
		} catch (InterruptedException e) {
			System.out.println("Várakozás megszakítva.");
		}
	}

}
