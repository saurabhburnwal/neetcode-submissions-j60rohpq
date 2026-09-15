class Solution {
    private int[] res;
    private int size;
    private int[] state;

    public int[] findOrder(int num, int[][] pre) {
        res = new int[num];
        size = 0;
        state = new int[num];
        
        List<Integer>[] adj = new ArrayList[num];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : pre)
            adj[edge[0]].add(edge[1]);

        for (int v = 0; v < num; v++)
            if (dfs(adj, v))    return new int[0];
        
        return res;
    }

    private boolean dfs(List<Integer>[] adj, int v) {
        if (state[v] == 1) return true;
        if (state[v] == 2) return false;

        state[v] = 1;

        for (int i : adj[v]) {
            if (dfs(adj, i))    return true;
        }

        state[v] = 2;
        res[size++] = v;
        return false;
    }
}
