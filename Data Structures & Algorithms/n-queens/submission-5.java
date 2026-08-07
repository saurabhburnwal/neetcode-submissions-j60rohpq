class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia1 = new HashSet<>();
    Set<Integer> dia2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        solve(0, board);
        return res;
    }

    public void solve(int row, char[][] board) {
        if (row == board.length) {
            List<String> set = new ArrayList<>();
            for (char[] r : board) {
                set.add(new String(r));
            }
            res.add(new ArrayList<>(set));
            return;
        }
        Arrays.fill(board[row], '.');
        for (int col = 0; col < board.length; col++) {
            if (!cols.contains(col) && !dia1.contains(row + col) && !dia2.contains(row - col)) {
                board[row][col] = 'Q';
                cols.add(col);
                dia1.add(row + col);
                dia2.add(row - col);
                solve(row + 1, board);
                board[row][col] = '.';
                cols.remove(col);
                dia1.remove(row + col);
                dia2.remove(row - col);
            }
        }
    }
}

