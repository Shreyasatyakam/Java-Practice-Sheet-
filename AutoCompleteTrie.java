import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {
    private final TrieNode root = new TrieNode();

    
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    
    public List<String> autoComplete(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return Collections.emptyList();
        }
        List<String> results = new ArrayList<>();
        collectWords(node, prefix, results);
        return results;
    }

    
    private void collectWords(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) results.add(prefix);
        for (var entry : node.children.entrySet()) {
            collectWords(entry.getValue(), prefix + entry.getKey(), results);
        }
    }
}

public class AutoCompleteTrie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        System.out.print("Enter number of words to insert: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            trie.insert(sc.nextLine().trim().toLowerCase());
        }

        while (true) {
            System.out.print("\nEnter prefix to autocomplete (or 'exit'): ");
            String prefix = sc.nextLine().trim().toLowerCase();

            if (prefix.equals("exit")) break;

            List<String> suggestions = trie.autoComplete(prefix);
            if (suggestions.isEmpty()) {
                System.out.println("No suggestions found.");
            } else {
                System.out.println("Suggestions: " + suggestions);
            }
        }

        sc.close();
    }
}
