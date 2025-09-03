import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // accessOrder = true means order is maintained by access (get/put)
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // remove oldest when full
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache<Integer, String> cache = new LRUCache<>(capacity);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Put (key, value)");
            System.out.println("2. Get (key)");
            System.out.println("3. Show cache");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter key (int): ");
                    int key = sc.nextInt();
                    System.out.print("Enter value (string): ");
                    String value = sc.next();
                    cache.put(key, value);
                    System.out.println("Added (" + key + ", " + value + ")");
                }
                case 2 -> {
                    System.out.print("Enter key to get: ");
                    int key = sc.nextInt();
                    String value = cache.get(key);
                    if (value != null) {
                        System.out.println("Value: " + value);
                    } else {
                        System.out.println("Key not found!");
                    }
                }
                case 3 -> System.out.println("Cache content: " + cache);
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
