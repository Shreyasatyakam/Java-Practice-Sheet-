import java.util.*;

public class WarehouseProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example input for Table-1
        String[][] table1 = {
            {"a", "b", "c", "d"},
            {"a", "a", "b", "b"},
            {"c", "d", "a", "b"},
            {"d", "-", "-", "b"}
        };

        // Example input for Table-2
        int[][] table2 = {
            {4, 5, 6, 2},
            {2, 1, 6, 8},
            {1, 3, 2, 9},
            {1, 0, 0, 1}
        };

        System.out.print("Enter input threshold: ");
        int threshold = sc.nextInt();

        // Count products
        Map<String, Integer> productCount = new HashMap<>();

        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[i].length; j++) {
                String product = table1[i][j];
                if (!product.equals("-")) {
                    productCount.put(product, productCount.getOrDefault(product, 0) + table2[i][j]);
                }
            }
        }

        // Collect products above threshold
        List<String> result = new ArrayList<>();
        for (var entry : productCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        System.out.println("Products meeting threshold: " + result);
    }
}
