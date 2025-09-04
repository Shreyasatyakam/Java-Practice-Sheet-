import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;

public class GZipCompression {

    // Compress a file
    public static void compressFile(String sourceFile, String destFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile);
             GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }
        }
    }

    // Decompress a file
    public static void decompressFile(String sourceFile, String destFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             GZIPInputStream gzipIS = new GZIPInputStream(fis);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipIS.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose operation: 1) Compress  2) Decompress");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        try {
            if (choice == 1) {
                System.out.print("Enter source file path: ");
                String source = sc.nextLine();
                System.out.print("Enter destination (compressed) file path: ");
                String dest = sc.nextLine();

                compressFile(source, dest);
                System.out.println("✅ File compressed successfully to " + dest);

            } else if (choice == 2) {
                System.out.print("Enter source (compressed) file path: ");
                String source = sc.nextLine();
                System.out.print("Enter destination (decompressed) file path: ");
                String dest = sc.nextLine();

                decompressFile(source, dest);
                System.out.println(" File decompressed successfully to " + dest);

            } else {
                System.out.println(" Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
