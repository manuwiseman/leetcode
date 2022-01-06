class TicTacToe {
    int[][] board;
    int n;
    int[][] rows = new int[][]{{0, 1}, {0, -1}};
    int[][] cols = new int[][]{{1, 0}, {-1, 0}};
    int[][] diagnols = new int[][]{{-1, 1}, {1, -1}};
    int[][] antiDiagnols = new int[][]{{1, 1}, {-1, -1}};
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        // 1. placing the marks into cell is easy
        board[row][col] = player;
        // 2. check whether a player wins is hard
        return playerWins(row, col, player) ? player : 0;
    }
    
    private boolean playerWins(int row, int col, int player) {
        return playerWinsByRow(row, col, player) ||
            playerWinsByCol(row, col, player) ||
            playerWinsByDiagnol(row, col, player) ||
            playerWinsByAntiDiagnol(row, col, player);
    }
    
    private boolean playerWinsByRow(int row, int col, int player) {
        int count = 1, left = col - 1, right = col + 1;
        while (left >= 0 && board[row][left] == player) {
            count++;
            left--;
        }
        while (right < n && board[row][right] == player) {
            count++;
            right++;
        }

        return count == n;
    }
    
    private boolean playerWinsByCol(int row, int col, int player) {
        int count = 1, up = row - 1, down = row + 1;
        while (up >= 0 && board[up][col] == player) {
            count++;
            up--;
        }
        while (down < n && board[down][col] == player) {
            count++;
            down++;
        }
        return count == n;
    }
    
    private boolean playerWinsByDiagnol(int row, int col, int player) {
        int count = 1, diagUpRow = row - 1, diagUpCol = col + 1, diagDownRow = row + 1, diagDownCol = col - 1;
        while (diagUpRow >= 0 && diagUpCol < n && board[diagUpRow][diagUpCol] == player) {
            count++;
            diagUpRow--;
            diagUpCol++;
        }
        while (diagDownRow < n  && diagDownCol >= 0 && board[diagDownRow][diagDownCol] == player) {
            count++;
            diagDownRow++;
            diagDownCol--;
        }
        return count == n;
    }
    
    private boolean playerWinsByAntiDiagnol(int row, int col, int player) {
        int count = 1, diagUpRow = row - 1, diagUpCol = col - 1, diagDownRow = row + 1, diagDownCol = col + 1;
        while (diagUpRow >= 0 && diagUpCol >= 0 && board[diagUpRow][diagUpCol] == player) {
            count++;
            diagUpRow--;
            diagUpCol--;
        }
        while (diagDownRow < n  && diagDownCol < n && board[diagDownRow][diagDownCol] == player) {
            count++;
            diagDownRow++;
            diagDownCol++;
        }
        return count == n;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */