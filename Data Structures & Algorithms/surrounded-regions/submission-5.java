class Solution {
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            dfs(board, r, 0);
            dfs(board, r, COLS - 1);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(board, 0, c);
            dfs(board, ROWS - 1, c);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'S') board[r][c] = 'O';
                else    board[r][c] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || board[r][c] != 'O')
            return;

        board[r][c] = 'S';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
} 
