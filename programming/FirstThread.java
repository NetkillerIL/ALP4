import java.util.Random;

// define run method in a Runnable class which will be loaded into a Thread 
public class FirstThread implements Runnable {
	Random rand = new Random();
	int  rndTime = rand.nextInt(5) + 1;	

    public void run() {
    	long threadId = Thread.currentThread().getId();
    	while (true) {
	        System.out.print("Hello from thread ");
	        System.out.println(threadId);
	        try {
	        	// sleeps random amout of time
	        	Thread.sleep(rndTime*1000);
	        }
	        catch (InterruptedException ex){
	        	System.out.println(ex);
	        }
        }

    }

    public static void main(String args[]) {
    	if(args.length > 1) {
    		System.out.println("expects only one argument");
    		return;
    	}

    	// creates and invokes threads 
    	int threadNum = Integer.parseInt(args[0]);
    	for (int i = 0; i < threadNum; i++) {
    		(new Thread(new FirstThread())).start();
    	}
    }

}
