import java.util.Scanner;

sealed interface Animal permits Dog, Cat, Bird {}

final class Dog implements Animal {
    void bark() {
        System.out.println("🐶 Woof! Woof!");
    }
}

final class Cat implements Animal {
    void meow() {
        System.out.println("🐱 Meowww!");
    }
}

final class Bird implements Animal {
    void chirp() {
        System.out.println("🐦 Chirp Chirp!");
    }
}

public class InstanceofPatternDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an animal (dog/cat/bird): ");
        String input = sc.nextLine().toLowerCase();

        Animal animal = switch (input) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            case "bird" -> new Bird();
            default -> null;
        };

        if (animal == null) {
            System.out.println("❌ Unknown animal.");
            return;
        }

        // Pattern matching for instanceof
        if (animal instanceof Dog d) {
            d.bark(); // no need to cast
        } else i
