class Solution {
    boolean[] colUsed;
    boolean[] diagonalUsed;
    boolean[] antiDiagonalUsed;
    char[][] board;
    int n;
    List<List<String>> ans;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        colUsed = new boolean[n];
        diagonalUsed = new boolean[2 * n - 1];
        antiDiagonalUsed = new boolean[2 * n - 1];
        board = new char[n][n];
        ans = new ArrayList<List<String>>();
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(0);
        return ans;   
    }
    
    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<String>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            ans.add(list);
        }
        for (int col = 0; col < n; col++) {
            int diagonalIdx = row + col;
            int antiDiagonalIdx = n - 1 - (row - col);
            if (colUsed[col] || diagonalUsed[diagonalIdx] || antiDiagonalUsed[antiDiagonalIdx]) continue;
            colUsed[col] = diagonalUsed[diagonalIdx] = antiDiagonalUsed[antiDiagonalIdx] = true;
            board[row][col] = 'Q';
            backtracking(row + 1);
            board[row][col] = '.';
            colUsed[col] = diagonalUsed[diagonalIdx] = antiDiagonalUsed[antiDiagonalIdx] = false;
        }
    }
}