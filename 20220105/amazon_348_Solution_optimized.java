class TicTacToe {
    int[] currentRow, currentCol;
    int diagnol, antiDiagnol, n;
    
    public TicTacToe(int n) {
        this.currentRow = new int[n];
        this.currentCol = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int mark = (player == 1 ? 1 : -1);
        currentRow[row] += mark;
        currentCol[col] += mark;
        if (row == col) antiDiagnol += mark;
        if (row + col == n - 1) diagnol += mark;
        
        if (Math.abs(currentRow[row]) == n ||
           Math.abs(currentCol[col]) == n ||
           Math.abs(diagnol) == n ||
           Math.abs(antiDiagnol) == n) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */