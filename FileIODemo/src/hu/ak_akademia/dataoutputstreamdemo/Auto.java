package hu.ak_akademia.dataoutputstreamdemo;

import java.io.Serializable;

public class Auto implements Serializable {

	private static final long serialVersionUID = 348475934579L;
//	private int numberOfDoors;
	private int speed;

	public Auto(int speed, int numberOfDoors) {
		this.speed = speed;
//		this.numberOfDoors = numberOfDoors;
	}
//
//	public int getNumberOfDoors() {
//		return numberOfDoors;
//	}
//
//	public void setNumberOfDoors(int numberOfDoors) {
//		this.numberOfDoors = numberOfDoors;
//	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auto [numberOfDoors=");
//		builder.append(numberOfDoors);
		builder.append(", speed=");
		builder.append(speed);
		builder.append("]");
		return builder.toString();
	}


}
