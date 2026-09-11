class Solution {
    class Trie {
        Trie[] next;
        List<String> words;

        Trie() {
            words = new ArrayList<>();
            next = new Trie[26];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie root = new Trie();

        for (String product: products) {
            Trie n = root;
            for (char ch: product.toCharArray()) {
                int index = ch - 'a';
                if (n.next[index] == null) {
                    n.next[index] = new Trie();
                }

                n = n.next[index];

                if (n.words.size() < 3) {
                    n.words.add(product);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Trie n = root;

        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            n = n.next[ch - 'a'];

            if (n == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    res.add(Collections.EMPTY_LIST);
                }
                break;
            }
            res.add(n.words);
        }
        return res;
    }
}