class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<List<String>>();
        Trie trie = new Trie();
        // 1. insert each product into Trie
        for (String p : products) {
            trie.insert(p);
        }
        
        // 2. search each prefix from Trie and add to final list
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            ans.add(trie.searchWordStartingWithPrefix(prefix));
        }
        
        return ans;
    }
}

class Trie {
    class Node {
        boolean isWord;
        List<Node> children = Arrays.asList(new Node[26]);
    }
    Node cur, root;
    List<String> resultSet;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String s) {
        cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children.get(c - 'a') == null) {
                cur.children.set(c - 'a', new Node());
            }
            cur = cur.children.get(c - 'a');
        }
        cur.isWord = true;
    }
    
    public List<String> searchWordStartingWithPrefix(String prefix) {
        cur = root;
        resultSet = new ArrayList<String>();
        for (char c : prefix.toCharArray()) {
            if (cur.children.get(c - 'a') == null) return resultSet;
            cur = cur.children.get(c - 'a');
        }
        dfs(cur, prefix);
        return resultSet;
    }
    
    private void dfs(Node cur, String word) {
        if (resultSet.size() == 3) return;
        if (cur.isWord == true) resultSet.add(word);
        for (char c = 'a'; c <= 'z'; c++) {
            if (cur.children.get(c - 'a') != null) {
                dfs(cur.children.get(c - 'a'), word + c);
            }
        }
    }
}