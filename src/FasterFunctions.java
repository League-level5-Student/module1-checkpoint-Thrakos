
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		
		Thread thread1 = new Thread(() -> {
			System.out.println("Starting slowSortLargeArray()...");
			SlowFunctions.slowSortLargeArray();
			System.out.println("slowSortLargeArray() Complete.");
		});
		
		Thread thread2 = new Thread(() -> {
			System.out.println("Starting ackermann(3, 14)...");
			System.out.println("ackermann(3, 14): " + SlowFunctions.ackermann(3, 14));
			System.out.println("ackermann(3, 14) Complete.");
		});
		
		Thread thread3 = new Thread(() -> {
			System.out.println("Starting millionsOfSqrts()...");
			SlowFunctions.millionsOfSqrts();
			System.out.println("millionsOfSqrts() Complete.");
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
