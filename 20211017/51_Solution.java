class Solution {
	boolean[] colUsed;
	boolean[] diagonalUsed;
	boolean[] antidiagonalUsed;
	char[][] board;
	List<List<String>>  res;
    int n;
    public List<List<String>> solveNQueens(int n) {
    	res = new ArrayList<>();
        this.board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        this.colUsed = new boolean[n];
        this.diagonalUsed = new boolean[2 * n - 1];
        this.antidiagonalUsed = new boolean[2 * n - 1];
        this.n = n;
        backtracking(0);
        return res;
    }

    private void backtracking(int row) {
    	if (row == n) {
    		List<String> list = new ArrayList<>();
    		for (char[] chars : board) {
    			list.add(new String(chars));
    		}
    		res.add(list);
    		return;
    	}

    	for (int col = 0; col < n; col++) {
    		int diagonalUsedIndex = row + col;
    		int antidiagonalUsedIndex = n - 1 - (row - col);
    		if (colUsed[col] || diagonalUsed[diagonalUsedIndex] || antidiagonalUsed[antidiagonalUsedIndex]) continue;
    		colUsed[col] = diagonalUsed[diagonalUsedIndex] = antidiagonalUsed[antidiagonalUsedIndex] = true;
    		board[row][col] = 'Q';
    		backtracking(row + 1);
    		board[row][col] = '.';
    		colUsed[col] = diagonalUsed[diagonalUsedIndex] = antidiagonalUsed[antidiagonalUsedIndex] = false;
    	}
    }
}