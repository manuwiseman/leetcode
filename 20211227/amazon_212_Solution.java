class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word;
    public TrieNode() {}
}

class Solution {
    List<String> ans;
    char[][] board;
    int m, n;
    int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        this.ans = new ArrayList<String>();
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        
        // 1. construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        
        // 2. backtracking
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }
        return ans;
    }
    
    public void backtracking(int i, int j, TrieNode parent) {
        char c = board[i][j];
        TrieNode cur = parent.children.get(c);
        if (cur.word != null) {
            ans.add(cur.word);
            cur.word = null;
        }
        // set cell to '#' for backtracking
        board[i][j] = '#';
        for (int[] nei : neighbors) {
            int nr = i + nei[0];
            int nc = j + nei[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || !cur.children.containsKey(board[nr][nc])) continue;
            backtracking(nr, nc, cur);
        }
        
        // revert cell to what it was
        board[i][j] = c;
        
        if (cur.children.isEmpty()) {
            parent.children.remove(c);
        }
    }
}