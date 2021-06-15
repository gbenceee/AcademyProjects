package hu.ak_akademia.hellothread;

public class MyThread extends Thread{

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("MyThread: " + i);
		}
	}

}
