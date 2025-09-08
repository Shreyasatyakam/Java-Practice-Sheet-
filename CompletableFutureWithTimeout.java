import java.util.concurrent.*;

public class CompletableFutureWithTimeout {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task started...");
                Thread.sleep(4000); 
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Task completed!";
        }, executor);

        try {
      
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Timeout! Task took too long.");
            future.cancel(true);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
