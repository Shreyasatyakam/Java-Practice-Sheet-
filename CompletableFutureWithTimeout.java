import java.util.concurrent.*;

public class CompletableFutureWithTimeout {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create a CompletableFuture with a task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task started...");
                Thread.sleep(4000); // Simulating long task (4s)
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Task completed!";
        }, executor);

        try {
            // Apply timeout (3 seconds)
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Timeout! Task took too long.");
            future.cancel(true); // cancel the task
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
