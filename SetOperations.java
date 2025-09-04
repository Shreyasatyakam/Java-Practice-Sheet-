import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of Set A (space-separated):");
        Set<Integer> setA = new HashSet<>();
        String[] aElements = sc.nextLine().split("\\s+");
        for (String s : aElements) setA.add(Integer.parseInt(s));

        System.out.println("Enter elements of Set B (space-separated):");
        Set<Integer> setB = new HashSet<>();
        String[] bElements = sc.nextLine().split("\\s+");
        for (String s : bElements) setB.add(Integer.parseInt(s));

        // Union
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union: " + union);

        // Intersection
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection: " + intersection);

        // Difference (A - B)
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);

        sc.close();
    }
}
