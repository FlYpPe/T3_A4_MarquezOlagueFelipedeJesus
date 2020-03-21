
public class LifeCycle implements Runnable{

	public static Thread thread1;
	public static LifeCycle obj;

	public static void main(String[] args) {
		obj = new LifeCycle();
		thread1 = new Thread(obj);

		// thread1 created and is currently in the NEW state.
		System.out.println("Estado de el hilo 1 despues de su creacion - " + thread1.getState());
		thread1.start();

		// thread1 moved to Runnable state
		System.out.println("Estado de el hilo 1 despues de su llamado .start() method on it - " + thread1.getState());
	}

	public void run() {
		thread myThread = new thread();
		Thread thread2 = new Thread(myThread);

		// thread1 created and is currently in the NEW state.
		System.out.println("Estado de el hilo 2 despues de su creacion - " + thread2.getState());
		thread2.start();

		// thread2 moved to Runnable state
		System.out.println("Estado de el hilo 2 despues de su llamado .start() method on it - " + thread2.getState());

		// moving thread1 to timed waiting state
		try {
			// moving thread1 to timed waiting state
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Estado de el hilo 2 despues de su llamado .sleep() method on it - " + thread2.getState());

		try {
			// waiting for thread2 to die
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Estado de el hilo 2 cuando este termina it's execution - " + thread2.getState());
	}

}

class thread implements Runnable {
	public void run() {
		// moving thread2 to timed waiting state
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Estado de el hilo 1 cuando este es llamado join() method on thread2 -" + LifeCycle.thread1.getState());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
