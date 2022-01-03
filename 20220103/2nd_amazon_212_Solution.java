// 1. convert the words array into a Trie data structure for faster check
// 2. once we have the trie, this is a backtracking problem
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
        
        // 1. create a trie from words array
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        // 2. loop thru the matrix and find mathcing word
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trie.root.children.containsKey(board[i][j])) {
                    backtracking(i, j, trie.root);
                }
            }
        }
        return ans;
    }
    
    private void backtracking(int row, int col, TrieNode parent) {
        char c = board[row][col];
        TrieNode curNode = parent.children.get(c);
        if(curNode.word != null) {
            ans.add(curNode.word);
            // as the question asked: "return all words on the board"
            curNode.word = null;
        }
        // set it to '#' to mark it as visited
        board[row][col] = '#';
        
        for (int[] nei : neighbors) {
            int nr = row + nei[0];
            int nc = col + nei[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && curNode.children.containsKey(board[nr][nc])) {
                backtracking(nr, nc, curNode);
            }
        }
        
        // set it back to c once backtracking is done
        board[row][col] = c;
        
        // to optimize the search time, remove empty node
        if (curNode.children.isEmpty()) {
            parent.children.remove(c);
        }
    }
}

class Trie {
    TrieNode root, node;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        node = root;
        for (char c : s.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.word = s;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word;
    public TrieNode(){}
}