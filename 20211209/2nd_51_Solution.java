class Solution {
    boolean[] colUsed;
    boolean[] diagonalUsed;
    boolean[] antiDiagonalUsed;
    char[][] board;
    int n;
    List<List<String>> ans;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.colUsed = new boolean[n];
        this.diagonalUsed = new boolean[2 * n - 1];
        this.antiDiagonalUsed = new boolean[2 * n - 1];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        this.ans = new ArrayList<List<String>>();
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
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonalIndex = row + col;
            int antiDiagonalIndex = n - 1 - (row - col);
            if (colUsed[col] || diagonalUsed[diagonalIndex] || antiDiagonalUsed[antiDiagonalIndex]) continue;
            colUsed[col] = diagonalUsed[diagonalIndex] = antiDiagonalUsed[antiDiagonalIndex] = true;
            board[row][col] = 'Q';
            backtracking(row + 1);
            board[row][col] = '.';
            colUsed[col] = diagonalUsed[diagonalIndex] = antiDiagonalUsed[antiDiagonalIndex] = false;
        }
    }
}