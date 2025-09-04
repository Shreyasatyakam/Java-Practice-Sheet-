import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedWordCounter {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path to the text file: ");
        String filePath = sc.nextLine();
        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            System.out.println("File does not exist.");
            sc.close();
            return;
        }

        List<String> lines = Files.readAllLines(path);
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        AtomicInteger totalCount = new AtomicInteger(0);
        List<Future<?>> futures = new CopyOnWriteArrayList<>();

        // Split lines for threads
        int chunkSize = (int) Math.ceil((double) lines.size() / numThreads);

        for (int i = 0; i < lines.size(); i += chunkSize) {
            int start = i;
            int end = Math.min(i + chunkSize, lines.size());

            futures.add(executor.submit(() -> {
                int count = 0;
                for (int j = start; j < end; j++) {
                    String[] words = lines.get(j).split("\\s+");
                    count += words.length;
                }
                totalCount.addAndGet(count);
            }));
        }

        // Wait for all threads to finish
        for (Future<?> f : futures) f.get();

        System.out.println("Total words in file: " + totalCount.get());
        executor.shutdown();
        sc.close();
    }
}
