class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean find(char[][] board, boolean[][] visited, String word, int i, int j, int p) {
        if (word.charAt(p) != board[i][j])
            return false;
        if (p == word.length() - 1) return true;
        
        visited[i][j] = true;

        boolean found =
            (i + 1 < board.length &&
            !visited[i + 1][j] &&
            find(board, visited, word, i + 1, j, p + 1))
        ||
            (j + 1 < board[0].length &&
            !visited[i][j + 1] &&
            find(board, visited, word, i, j + 1, p + 1))
        ||
            (i > 0 &&
            !visited[i - 1][j] &&
            find(board, visited, word, i - 1, j, p + 1))
        ||
            (j > 0 &&
            !visited[i][j - 1] &&
            find(board, visited, word, i, j - 1, p + 1));

        visited[i][j] = false;
        return found;
    }
}
