class Solution {
    private boolean[][] pac;
    private boolean[][] atl;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        ROWS = heights.length;
        COLS = heights[0].length;
        pac = new boolean[ROWS][COLS];
        atl = new boolean[ROWS][COLS];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            dfs(heights, i, 0, pac, 0);
            dfs(heights, i, COLS - 1, atl, 0);
        }

        for (int j = 0; j < COLS; j++) {
            dfs(heights, 0, j, pac, 0);
            dfs(heights, ROWS - 1, j, atl, 0);
        }
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pac[i][j] && atl[i][j])
                    res.add(List.of(i, j));
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] v, int prev) {

        if (r < 0 || c < 0 || r == ROWS || c == COLS || v[r][c] || heights[r][c] < prev) 
            return;
        
        v[r][c] = true;

        for (int[] d : dir) {
            dfs(heights, r + d[0], c + d[1], v, heights[r][c]);
        }
    }
}
