import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class DirectorySizeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter directory path: ");
        String dirPath = sc.nextLine();

        Path path = Paths.get(dirPath);

        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println("❌ Invalid directory path!");
            return;
        }

        try (Stream<Path> walk = Files.walk(path)) {
            long size = walk
                    .filter(Files::isRegularFile) 
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            return 0L;
                        }
                    })
                    .sum();

            System.out.println("Total size of directory '" + dirPath + "' = " + size + " bytes");
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }

        sc.close();
    }
}
