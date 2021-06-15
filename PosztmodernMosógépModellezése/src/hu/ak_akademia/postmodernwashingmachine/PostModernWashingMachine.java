package hu.ak_akademia.postmodernwashingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PostModernWashingMachine {
	private boolean isSwitchedOn;
	private boolean isTheDoorOpened;
	private State stateOfMachine = isSwitchedOn ? State.ON : State.OFF;

	public PostModernWashingMachine(boolean isSwitchedOn, boolean isTheDoorOpened) {
		this.isSwitchedOn = isSwitchedOn;
		this.isTheDoorOpened = isTheDoorOpened;
	}

	public void switchOn() {
		if (isSwitchedOn) {
			System.out.println("A mosógép már be van kapcsolva.");
		} else {
			System.out.println("A mosógép bekapcsolva.");
			isSwitchedOn = true;
			stateOfMachine = State.ON;
		}
	}

	public void switchOff() {
		if (isSwitchedOn == false) {
			System.out.println("A mosógép már ki van kapcsolva.");
		} else {
			System.out.println("A mosógép kikapcsolva.");
			isSwitchedOn = false;
			stateOfMachine = State.OFF;
		}
	}

	public void open() {
		if (isTheDoorOpened) {
			System.out.println("A mosógép ajtaja már ki van nyitva.");
		} else if (stateOfMachine.equals(State.WASHING)) {
			System.out.println("A mosás folyamatban!");
		} else {
			System.out.println("A mosógép ajtaja kinyitva.");
			isTheDoorOpened = true;
		}
	}

	public void close() {
		if (isTheDoorOpened == false) {
			System.out.println("A mosógép ajtaja már be van zárva.");
		} else {
			isTheDoorOpened = false;
			System.out.println("A mosógép ajtaja bezárva.");
		}
	}

	public void load(ArrayList<Dress> myClothes, Dress... washables) {
		if (isSwitchedOn) {
			if (isTheDoorOpened) {
				Collections.addAll(myClothes, washables);
				System.out.println("A ruhák betöltése kész.");
			} else {
				System.out.println("A mosógép ajtaját először ki kell nyitnia.");
			}
		} else {
			System.out.println("A mosógép ki van kapcsolva, ezért a művelet nem hajtható végre.");
		}
	}

	public void unload(ArrayList<Dress> myClothes, Dress... dresses) {
		if (isTheDoorOpened) {
			for (int i = 0; i < myClothes.size(); i++) {
				dresses[i] = myClothes.get(i);
			}
			System.out.println("A ruhákat kivettük a mosógépből.");
		} else {
			System.out.println("A mosógép ajtaját először ki kell nyitni ahhoz, hogy kivegyük a ruhákat.");
		}
	}

	public void iron(ArrayList<Dress> myClothes) {
		if (isSwitchedOn) {
			for (int i = 0; i < myClothes.size(); i++) {
				myClothes.get(i)
						.iron();
			}
			System.out.println("A ruhák vasalása kész.");
		} else {
			System.out.println("A mosógép ki van kapcsolva, ezért a művelet nem hajtható végre.");
		}
	}

	public void dry(ArrayList<Dress> myClothes) {
		if (isSwitchedOn) {
			for (int i = 0; i < myClothes.size(); i++) {
				myClothes.get(i)
						.dry();
			}
			System.out.println("A ruhák szárítása kész.");

		} else {
			System.out.println("A mosógép ki van kapcsolva, ezért a művelet nem hajtható végre.");
		}
	}

	public void check(ArrayList<Dress> myClothes, ArrayList<String> message) {
		int sumOfDirtiness = countSumOfDirtiness(myClothes);
		boolean isLaunchable = true;
		boolean[] isMachineFilledWithIncorrectClothes = { isMachineEmpty(myClothes), isMachineFilledWithColoredAndWhiteClothes(myClothes),
				isSumOfDirtinessOutOfBounds(myClothes, sumOfDirtiness, sumOfDirtiness > 800), isSumOfDirtinessOutOfBounds(myClothes, sumOfDirtiness, sumOfDirtiness < 50) };
		String[] errorMessages = { "A gépben egy betöltött ruha sincs.", "A gépben színes és fehér ruhák is vannak.", "A gépbe töltött ruhák összkoszossága meghaladja a 800-as értéket.",
				"A gépbe töltött ruhák összkoszossága nem éri el az 50-es értéket." };
		if (isSwitchedOn) {
			for (int i = 0; i < isMachineFilledWithIncorrectClothes.length; i++) {
				if (isMachineFilledWithIncorrectClothes[i]) {
					message.add(errorMessages[i]);
					isLaunchable = false;
				}
			}
			if (isLaunchable) {
				message.add("OK");
			}
		} else {
			System.out.println("A mosógép ki van kapcsolva, ezért a művelet nem hajtható végre.");
		}
	}

	private int countSumOfDirtiness(ArrayList<Dress> myClothes) {
		int sumOfDirtiness = 0;
		for (int i = 0; i < myClothes.size(); i++) {
			sumOfDirtiness += myClothes.get(i)
					.getScaleOfDirtiness();
			if (sumOfDirtiness > 800) {
				break;
			}
		}
		return sumOfDirtiness;
	}

	private boolean isSumOfDirtinessOutOfBounds(ArrayList<Dress> myClothes, int sumOfDirtiness, boolean condition) {
		if (condition) {
			return true;
		}
		return false;
	}

	private boolean isMachineEmpty(ArrayList<Dress> myClothes) {
		return myClothes.size() == 0;
	}

	private boolean isMachineFilledWithColoredAndWhiteClothes(ArrayList<Dress> myClothes) {
		boolean isDressColorful = false;
		boolean isDressWhite = false;
		for (int i = 0; i < myClothes.size(); i++) {
			if (myClothes.get(i)
					.isColorful()) {
				isDressColorful = true;
			} else {
				isDressWhite = true;
			}
			if (isDressColorful && isDressWhite) {
				return true;
			}
		}
		return false;
	}

	public void startWash(ArrayList<Dress> myClothes, ArrayList<String> message, Random random) throws InterruptedException {
		if (isSwitchedOn && message.contains("OK") && isTheDoorOpened == false) {
			stateOfMachine = State.WASHING;
			boolean[] isClothesTorned = new boolean[myClothes.size()];
			System.out.println("A mosás folyamatban.");
			do {
				for (int i = 0; i < myClothes.size(); i++) {
					myClothes.get(i)
							.clean();
					if (myClothes.get(i)
							.getDurability() <= 0 && !isClothesTorned[i]) {
						myClothes.get(i)
								.setDressTorned();
						isClothesTorned[i] = true;
						System.out.println("A " + myClothes.get(i)
								.getNameOfDress() + " elszakadt.");
					} else if (!isClothesTorned[i]) {
						myClothes.get(i)
								.decreaseDurability(random.nextInt(3) + 1);
					}
					Thread.sleep(1000);
				}
				System.out.println("A ruhák koszossága egyel csökkent.");
			} while (isSumOfDirtinessGreaterThanThirty(myClothes));
			System.out.println("A mosás lejárt.");
			stateOfMachine = State.ON;
		} else {
			System.out.println("A mosás nem hajtható végre.");
			System.out.println("Kérem, ellenőrizze, hogy be van-e kapcsolva a mosógép és be van-e zárva az ajtaja.");
		}
	}

	private boolean isSumOfDirtinessGreaterThanThirty(ArrayList<Dress> myClothes) {
		return countSumOfDirtiness(myClothes) > 30;
	}

}
