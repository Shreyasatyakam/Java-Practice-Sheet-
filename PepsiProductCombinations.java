import java.util.*;

public class PepsiProductCombinations {
    static List<List<Integer>> result = new ArrayList<>();

    public static void findCombinations(int[] prices, int target, int start, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < prices.length; i++) {
            current.add(prices[i]);
            findCombinations(prices, target - prices[i], i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        System.out.print("Enter deposit amount: ");
        int deposit = sc.nextInt();

        findCombinations(prices, deposit, 0, new ArrayList<>());

        System.out.println("Possible combinations:");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
