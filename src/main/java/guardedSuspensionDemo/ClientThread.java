package guardedSuspensionDemo;

import java.util.Random;

public class ClientThread extends Thread{

	private final Random random; 
	private final RequestQueue requestQueue;
	
	public ClientThread(RequestQueue requestQueue,String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		random = new Random(seed);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Request request = new Request("No." + i); 
			System.out.println(Thread.currentThread().getName() + " Request " + request);
			requestQueue.putRequest(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (Exception e) {
			}
		}

	}
	
}