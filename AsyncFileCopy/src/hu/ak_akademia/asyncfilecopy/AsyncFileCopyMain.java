package hu.ak_akademia.asyncfilecopy;

import java.io.File;
import java.util.Arrays;

public class AsyncFileCopyMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("A copyFrom mappában a következő fájlokat találtam:");
		File copyFromFolder = new File("copyFrom");
		File[] filesToCopy = copyFromFolder.listFiles();
		for (File file : filesToCopy) {
			System.out.println("- " + file.getName());
		}
		Runnable copyTask = new CopyFilesTask(Arrays.asList(filesToCopy), "copyTo");
		// ha a run metódust hívjuk meg, akkor a main szál szinkron futtatja le a
		// feladatot
		// ez csak egy sima metódus hívás
//	      copyTask.run();
		Thread copyThread = new Thread(copyTask);
		copyThread.start();
		System.out.println("main szál várakozik 40 másodpercet...");
		Thread.sleep(40_000L);
		System.out.println("main szál várakozás vége.");
		System.out.println("main szál most interrupt-ot küld a fájlok másolását végző szálnak.");
		copyThread.interrupt();
		System.out.println("main szál megvárja a fájlok másolását végző szál leállását.");
		copyThread.join();
		System.out.println("A program futása befejeződött.");
	}

}
