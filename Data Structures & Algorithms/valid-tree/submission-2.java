class Solution {

    private int[] state;

    public boolean validTree(int n, int[][] edges) {
        List[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        state = new int[n];

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        if (hasCycle(adj, 0, -1))   return false;
        for (int s : state) if (s != 2) return false;

        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int node, int pnode) {
        if (state[node] == 1)   return true;
        if (state[node] == 2)   return false;

        state[node] = 1;

        for (int i : adj[node]) {
            if (pnode != i && hasCycle(adj, i, node))   return true;
        }

        state[node] = 2;
        return false;
    }
}
