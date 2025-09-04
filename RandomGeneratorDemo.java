import java.util.random.RandomGenerator;

public class RandomGeneratorDemo {
    public static void main(String[] args) {
        // Create a random generator (uses default algorithm)
        RandomGenerator rng = RandomGenerator.getDefault();

        // Generate random integers between 0 and 99
        System.out.println("Random Integers:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rng.nextInt(100));
        }

        // Generate random doubles between 0.0 and 1.0
        System.out.println("\nRandom Doubles:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rng.nextDouble());
        }

        // Generate random booleans
        System.out.println("\nRandom Booleans:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rng.nextBoolean());
        }
    }
}
