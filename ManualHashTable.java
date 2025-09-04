import java.util.LinkedList;
import java.util.Scanner;

// Key-Value pair
class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// Manual HashTable
class HashTable<K, V> {
    private final int SIZE = 10;
    private final LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert key-value
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    // Get value by key
    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    // Display HashTable
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : table[i]) {
                System.out.print("[" + entry.key + "->" + entry.value + "] ");
            }
            System.out.println();
        }
    }
}

public class ManualHashTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable<String, String> hashTable = new HashTable<>();

        while (true) {
            System.out.println("\n--- Manual HashTable ---");
            System.out.println("1. Insert key-value");
            System.out.println("2. Get value by key");
            System.out.println("3. Display table");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    String value = sc.nextLine();
                    hashTable.put(key, value);
                    System.out.println("Inserted!");
                }
                case 2 -> {
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    String value = hashTable.get(key);
                    if (value != null)
                        System.out.println("Value: " + value);
                    else
                        System.out.println("Key not found.");
                }
                case 3 -> hashTable.display();
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
