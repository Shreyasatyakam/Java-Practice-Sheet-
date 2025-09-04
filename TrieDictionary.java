import java.util.Scanner;

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // lowercase a-z
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search a word
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
}

public class TrieDictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        System.out.println("--- Trie Dictionary ---");
        System.out.println("Enter words to insert into the trie (comma separated):");
        String[] words = sc.nextLine().split(",");
        for (String word : words) {
            trie.insert(word.trim());
        }

        while (true) {
            System.out.print("Enter a word to search (or 'exit' to quit): ");
            String query = sc.nextLine().trim();
            if (query.equalsIgnoreCase("exit")) break;

            if (trie.search(query)) {
                System.out.println("'" + query + "' is present in the dictionary.");
            } else {
                System.out.println("'" + query + "' is NOT present in the dictionary.");
            }
        }

        sc.close();
    }
}
