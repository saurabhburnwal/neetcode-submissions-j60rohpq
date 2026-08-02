class Solution {
    private int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (find(board, visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean find(char[][] board, boolean[][] visited, String word, int i, int j, int p) {
        if (p == word.length())    return true;
        boolean left, right, up, down;
        left = right = up = down = false;
        if (word.charAt(p) == board[i][j]) {
            visited[i][j] = true;
            if (i + 1 < ROWS && visited[i + 1][j] == false)
                down = find(board, visited, word, i + 1, j, p + 1);
            if (j + 1 < board[i].length && visited[i][j + 1] == false)
                right = find(board, visited, word, i, j + 1, p + 1);
            if (i > 0 && visited[i - 1][j] == false)
                up = find(board, visited, word, i - 1, j, p + 1);
            if (j > 0 && visited[i][j - 1] == false)
                left = find(board, visited, word, i, j - 1, p + 1);
            if (p == word.length() - 1) return true;
        }
        visited[i][j] = false;
        return down || up || left || right;
    }
}
