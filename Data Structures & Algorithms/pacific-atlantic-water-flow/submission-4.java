class Solution {
    boolean v[][];
    int[][] dir = {{ -1, 0}, {0, -1}, {1, 0}, { 0, 1}};
    boolean[][] pacif;
    boolean[][] atlan; 
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        List<List<Integer>> res = new ArrayList<>();
        pacif = new boolean[ht.length][ht[0].length];
        atlan = new boolean[ht.length][ht[0].length];

        for(int i = 0; i < ht.length; i++) {
            for(int j = 0; j < ht[i].length; j++) {
                v = new boolean[ht.length][ht[0].length];
                pacif[i][j] = checkP(ht, i ,j, v);
                atlan[i][j] = checkA(ht, i, j, v);
            }
        }

        for(int i = 0; i < ht.length; i++) {
            for(int j = 0; j < ht[i].length; j++) {
                if(pacif[i][j] && atlan[i][j]) {
                   res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    public boolean checkA(int[][] ht, int r, int c, boolean v[][]) {
        if(c == ht[0].length - 1 || r == ht.length - 1 || atlan[r][c]) return true;

        for(int[] d: dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr == ht.length || nc == ht[0].length || v[nr][nc]) continue;
            if (ht[nr][nc] <= ht[r][c]) {
                v[nr][nc] = true;
                if (checkA(ht, nr, nc, v)) return true;
            }
        }
        return false;
    }

    public boolean checkP(int[][] ht, int r, int c, boolean v[][]) {     
        if (c == 0 || r == 0 || pacif[r][c]) return true;

        for (int[] d: dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr == ht.length || nc == ht[0].length || v[nr][nc]) continue;
            if (ht[nr][nc] <= ht[r][c]) {
                v[nr][nc] = true;
                if (checkP(ht, nr, nc, v)) return true;
            }
        }
        return false;
    }
    
}

// r c 0 1 2 3 4
// 0   1 1 1 1 2
// 1   1 0 0 0 1
// 2   2 1 1 1 1