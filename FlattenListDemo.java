import java.util.*;
import java.util.stream.*;

public class FlattenListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of sublists
        System.out.print("Enter number of sublists: ");
        int n = sc.nextInt();

        List<List<Integer>> listOfLists = new ArrayList<>();

        // Input sublists
        for (int i = 0; i < n; i++) {
            System.out.print("Enter size of sublist " + (i + 1) + ": ");
            int size = sc.nextInt();

            List<Integer> sublist = new ArrayList<>();
            System.out.println("Enter " + size + " elements:");
            for (int j = 0; j < size; j++) {
                sublist.add(sc.nextInt());
            }
            listOfLists.add(sublist);
        }

        // Flatten using flatMap
        List<Integer> flatList = listOfLists.stream()
                                            .flatMap(List::stream)
                                            .collect(Collectors.toList());

        System.out.println("Flattened List: " + flatList);

        sc.close();
    }
}
