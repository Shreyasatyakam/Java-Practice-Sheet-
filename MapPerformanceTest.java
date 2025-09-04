import java.util.*;

public class MapPerformanceTest {
    public static void main(String[] args) {
        int n = 1_000_000; // number of elements

        // Prepare random keys and values
        Random rand = new Random();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            keys.add(rand.nextInt(n * 10));
        }

        // Test HashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        long start = System.currentTimeMillis();
        for (Integer key : keys) {
            hashMap.put(key, key);
        }
        long end = System.currentTimeMillis();
        System.out.println("HashMap insertion time: " + (end - start) + " ms");

        // Search in HashMap
        start = System.currentTimeMillis();
        for (Integer key : keys) {
            hashMap.get(key);
        }
        end = System.currentTimeMillis();
        System.out.println("HashMap search time: " + (end - start) + " ms");

        // Delete in HashMap
        start = System.currentTimeMillis();
        for (Integer key : keys) {
            hashMap.remove(key);
        }
        end = System.currentTimeMillis();
        System.out.println("HashMap deletion time: " + (end - start) + " ms");

        System.out.println("\n--- TreeMap Test ---\n");

        // Test TreeMap
        Map<Integer, Integer> treeMap = new TreeMap<>();
        start = System.currentTimeMillis();
        for (Integer key : keys) {
            treeMap.put(key, key);
        }
        end = System.currentTimeMillis();
        System.out.println("TreeMap insertion time: " + (end - start) + " ms");

        // Search in TreeMap
        start = System.currentTimeMillis();
        for (Integer key : keys) {
            treeMap.get(key);
        }
        end = System.currentTimeMillis();
        System.out.println("TreeMap search time: " + (end - start) + " ms");

        // Delete in TreeMap
        start = System.currentTimeMillis();
        for (Integer key : keys) {
            treeMap.remove(key);
        }
        end = System.currentTimeMillis();
        System.out.println("TreeMap deletion time: " + (end - start) + " ms");
    }
}
