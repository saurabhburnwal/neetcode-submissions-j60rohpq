class Solution {
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    t.add(new int[] {i, j});
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.addAll(t);
        while (!q.isEmpty()) {
            int[] d = q.poll();
            int i = d[0], j = d[1];
            if (i - 1 >= 0 && grid[i - 1][j] == 2147483647) {
                q.offer(new int[] {i - 1, j});
                grid[i - 1][j] = grid[i][j] + 1;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 2147483647) {
                q.offer(new int[] {i, j - 1});
                grid[i][j - 1] = grid[i][j] + 1;
            }
            if (i + 1 < grid.length && grid[i + 1][j] == 2147483647) {
                q.offer(new int[] {i + 1, j});
                grid[i + 1][j] = grid[i][j] + 1;
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == 2147483647) {
                q.offer(new int[] {i, j + 1});
                grid[i][j + 1] = grid[i][j] + 1;
            }
        }
    }
}