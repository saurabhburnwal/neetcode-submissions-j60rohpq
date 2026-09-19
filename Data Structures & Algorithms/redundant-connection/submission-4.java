class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        boolean[] cycle = new boolean[n];

        dfs(adj, vis, 1, 0, cycle);

        System.out.println(Arrays.toString(cycle));

        for (int i = n - 2; i >= 0; i--) {
            if (cycle[edges[i][0]] && cycle[edges[i][1]])
                return edges[i];
        }
        return new int[0];
    }

    private int dfs(List<Integer>[] adj, boolean[] vis, int node, int pNode, boolean[] cycle) {
        if (vis[node]) {
            cycle[node] = true;
            return node;
        }
        vis[node] = true;
        
        for (int i : adj[node]) {
            if (pNode == i) continue;

            int s = dfs(adj, vis, i, node, cycle);

            if (s != -1) {
                cycle[node] = true;
                if (node == s)
                    return -1;

                return s;
            }
        }

        return -1;
    }
}
