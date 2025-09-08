import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class DirectoryCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter source directory path: ");
        Path sourceDir = Paths.get(sc.nextLine());

        System.out.print("Enter destination directory path: ");
        Path destDir = Paths.get(sc.nextLine());

        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            System.out.println("❌ Source is not a valid directory.");
            return;
        }

        try {
          
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path targetDir = destDir.resolve(sourceDir.relativize(dir));
                    if (!Files.exists(targetDir)) {
                        Files.createDirectories(targetDir);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetFile = destDir.resolve(sourceDir.relativize(file));
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("✅ Directory copied successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error while copying: " + e.getMessage());
        }

        sc.close();
    }
}
