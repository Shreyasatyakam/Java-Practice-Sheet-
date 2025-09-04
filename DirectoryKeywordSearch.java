import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.stream.Stream;

public class DirectoryKeywordSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take directory path from user
        System.out.print("Enter directory path: ");
        String dirPath = sc.nextLine();

        // Take keyword to search
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        Path path = Paths.get(dirPath);

        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println("❌ Invalid directory path.");
            sc.close();
            return;
        }

        System.out.println("\nSearching for '" + keyword + "' in directory: " + dirPath + "\n");

        try {
            // Walk through directory recursively
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    // Only check regular files
                    if (Files.isRegularFile(file)) {
                        try (Stream<String> lines = Files.lines(file)) {
                            long count = lines.filter(line -> line.contains(keyword)).count();
                            if (count > 0) {
                                System.out.println("Keyword found in: " + file + " (" + count + " occurrence(s))");
                            }
                        } catch (IOException e) {
                            System.out.println("Failed to read file: " + file);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
