class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (word.length() == 1) return true;
                    else    res = res || find(board, visited, word, i, j, 0);
                }
            }
        }
        return res;
    }
    public boolean find(char[][] board, boolean[][] visited, String word, int i, int j, int p) {
        if (p == word.length())    return true;
        boolean left, right, up, down;
        left = right = up = down = false;
        if (board[i][j] != word.charAt(p)) {
            return false;
        } else {
            visited[i][j] = true;
            if (i + 1 < board.length && visited[i + 1][j] == false)
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
