import java.util.Scanner;
import java.util.WeakHashMap;

public class WeakHashMapCache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a WeakHashMap for caching
        WeakHashMap<String, String> cache = new WeakHashMap<>();

        while (true) {
            System.out.println("\n=== Cache Menu ===");
            System.out.println("1. Put data in cache");
            System.out.println("2. Get data from cache");
            System.out.println("3. Show entire cache");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    String value = sc.nextLine();
                    cache.put(key, value);
