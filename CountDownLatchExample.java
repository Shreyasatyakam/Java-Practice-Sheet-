import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private final int id;
    private final CountDownLatch latch;

    public Worker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker " + id + " is starting task...");
            Thread.sleep((long) (Math.random() * 2000)); 
            System.out.println("Worker " + id + " has finished task.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numWorkers = 5;
        CountDownLatch latch = new CountDownLatch(numWorkers);

      
        for (int i = 1; i <= numWorkers; i++) {
            new Worker(i, latch).start();
        }

        try {
            System.out.println("Main thread waiting for workers to finish...");
            latch.await();
            System.out.println("All workers finished. Main thread proceeding!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
