class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                if (grid[i][j] == 1) {
                    count++;
                }

            }
        }
        
        int time = 0;
        while (count > 0 && !q.isEmpty()) {
            int length = q.size();
            for (int it = 0; it < length; it++) {
                int[] d = q.poll();
                int i = d[0], j = d[1];
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    q.offer(new int[] {i - 1, j});
                    grid[i - 1][j] = 2;
                    count--;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    q.offer(new int[] {i, j - 1});
                    grid[i][j - 1] = 2;
                    count--;
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    q.offer(new int[] {i + 1, j});
                    grid[i + 1][j] = 2;
                    count--;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    q.offer(new int[] {i, j + 1});
                    grid[i][j + 1] = 2;
                    count--;
                }
            }
            time++;
        }
        return count == 0 ? time : -1;
    }
}
