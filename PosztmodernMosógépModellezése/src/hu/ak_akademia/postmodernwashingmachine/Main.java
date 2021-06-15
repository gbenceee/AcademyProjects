package hu.ak_akademia.postmodernwashingmachine;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		PostModernWashingMachine mosógépTeszt = new PostModernWashingMachine(false, false);
		Dress sweater = new Sweater(20, false, "pulcsi", 100);
		Dress shirt = new Shirt(10, false, "ing", 100);
		Dress socks = new Socks(10, false, "zokni", 100);
		Dress pants = new Pants(10, false, "nadrág", 100);
		ArrayList<Dress> myClothes = new ArrayList<Dress>();
		ArrayList<String> message = new ArrayList<String>();
		mosógépTeszt.switchOn();
		mosógépTeszt.open();
		mosógépTeszt.load(myClothes, sweater, shirt, socks, pants);
		mosógépTeszt.check(myClothes, message);
		for (int i = 0; i < message.size(); i++) {
			System.out.println(message.get(i));
		}
		mosógépTeszt.close();
		mosógépTeszt.startWash(myClothes, message, random);
		mosógépTeszt.dry(myClothes);
		mosógépTeszt.iron(myClothes);
		mosógépTeszt.open();
		mosógépTeszt.unload(myClothes, sweater, shirt, socks, pants);
		mosógépTeszt.switchOff();
		System.out.println(sweater);
		System.out.println(shirt);
		System.out.println(socks);
		System.out.println(pants);

	}

}
