import java.util.*;

public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Suits and Ranks
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Build deck
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        // Shuffle deck
        Collections.shuffle(deck);

        // User input
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsEach = sc.nextInt();

        // Check if enough cards
        if (players * cardsEach > deck.size()) {
            System.out.println("❌ Not enough cards in the deck!");
            return;
        }

        // Deal cards
        for (int i = 0; i < players; i++) {
            System.out.println("Player " + (i + 1) + "'s hand: " +
                    deck.subList(i * cardsEach, (i + 1) * cardsEach));
        }

        sc.close();
    }
}
