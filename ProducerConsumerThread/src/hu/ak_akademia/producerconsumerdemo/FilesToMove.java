package hu.ak_akademia.producerconsumerdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilesToMove {

	private final List<String> fileNames = Collections.synchronizedList(new ArrayList<>());

	public synchronized void put(String fileName) {
		while (fileNames.size() > 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// senki sem küld interrupt-ot
			}
		}
		fileNames.add(fileName);
		notifyAll();
	}

	public synchronized String take() {
		while (fileNames.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// senki sem küld interrupt-ot
			}
		}
		String fileName = fileNames.remove(0);
		notifyAll();
		return fileName;
	}

}
