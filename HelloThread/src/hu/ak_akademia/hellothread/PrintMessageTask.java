package hu.ak_akademia.hellothread;

public class PrintMessageTask implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while(true) {
			i++;
			System.out.println(i + ". text.");
			try {
				Thread.sleep(4000L);
			} catch (InterruptedException e) {
				System.out.println("Megszakítva.");
				break;
			}
		}
		System.out.println("Szál vége.");
	}

}
