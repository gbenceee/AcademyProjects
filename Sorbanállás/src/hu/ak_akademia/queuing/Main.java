package hu.ak_akademia.queuing;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Adult ferenc = new Adult("Ferenc", 35, 4);
		Adult attila = new Adult("Attila", 39, 8);
		OldPerson istván = new OldPerson("István", 57, 10);
		OldPerson imre = new OldPerson("Imre", 60, 15);
		YoungAdult gábor = new YoungAdult("Gábor", 22, 4);
		YoungAdult lászló = new YoungAdult("Lászó", 24, 3);
		Queue<PersonPreparator> queue = new LinkedList<>();
		queue.add(ferenc);
		queue.add(attila);
		queue.add(istván);
		queue.add(imre);
		queue.add(gábor);
		queue.add(lászló);
		// @formatter:off
		while(!queue.isEmpty()){
			System.out.println(queue.peek().getName() + "(" + queue.peek().getAge() + ")" + " tartózkodik a pénztárnál.");
			queue.peek().checkOut();
			System.out.println(queue.peek().getName() + "(" + queue.peek().getAge() + ")" + " befejezte a vásárlást, " + queue.peek().getCheckOutTime() + " másodeprcig várt a pénztárosra.");
			queue.remove();
		}
		// @formatter:on
		System.out.println("A pénztár bezár!");
	}

}
