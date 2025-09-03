import java.util.Optional;

public class OptionalSimpleDemo {
    public static void main(String[] args) {
        String name = null;  // imagine this came from somewhere (DB, API, user input)

        // Wrap it safely in Optional
        Optional<String> optName = Optional.ofNullable(name);

        // Provide a default if null
        String finalName = optName.orElse("Guest");

        System.out.println("Hello, " + finalName + "!");
    }
}
