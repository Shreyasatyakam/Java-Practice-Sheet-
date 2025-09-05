import java.util.*;

public class PepsiProductAssignment {
    static int countWays(List<List<String>> pepProducts, int person, Set<String> used) {
        if (person == pepProducts.size()) return 1; // all assigned

        int ways = 0;
        for (String product : pepProducts.get(person)) {
            if (!used.contains(product)) {
                used.add(product);
                ways += countWays(pepProducts, person + 1, used);
                used.remove(product);
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<List<String>> pepProducts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter preferred products for person " + (i+1) + " (comma separated):");
            String line = sc.nextLine();
            List<String> prefs = Arrays.asList(line.split(","));
            pepProducts.add(prefs);
        }

        int result = countWays(pepProducts, 0, new HashSet<>());
        System.out.println("Number of ways: " + result);
    }
}
