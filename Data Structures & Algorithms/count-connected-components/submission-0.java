class Solution {
    boolean[] vis;
    public int countComponents(int n, int[][] edges) {
        
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        int count = 0;

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(List<Integer>[] adj, int node) {
        vis[node] = true;
        for (int i : adj[node]) {
            if (!vis[i])
                dfs(adj, i);
        }
    }
}
