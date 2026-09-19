class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n + 1];
        Set<Integer> cycle = new HashSet<>();

        dfs(adj, vis, 1, 0, cycle);

        for (int i = n - 1; i >= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1]))
                return edges[i];
        }
        return new int[0];
    }

    private int dfs(List<Integer>[] adj, boolean[] vis, int node, int pNode, Set<Integer> cycle) {
        if (vis[node]) {
            cycle.add(node);
            return node;
        }
        vis[node] = true;
        
        for (int i : adj[node]) {
            if (pNode == i) continue;

            int s = dfs(adj, vis, i, node, cycle);
            if (s != -1) {
                cycle.add(node);
                if (node == s)
                    return -1;

                return s;
            }
        }

        return -1;
    }
}
