import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTasksDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

     
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task1: Computing square of " + a);
            sleep(1000); 
            return a * a;
        });

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task2: Computing cube of " + b);
            sleep(1200);
            return b * b * b;
        });

 
        CompletableFuture<Integer> combined = task1.thenCombine(task2, (sq, cube) -> {
            System.out.println("Combining results...");
            return sq + cube;
        });

 
        System.out.println("Final Result (square(a) + cube(b)) = " + combined.get());

        sc.close();
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
