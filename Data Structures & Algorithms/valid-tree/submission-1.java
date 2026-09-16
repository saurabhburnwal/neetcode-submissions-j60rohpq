class Solution {
    
    private int[] state;

    public boolean validTree(int n, int[][] edges) {

        state = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        if (hasCycle(adj, 0))   return false;

        for (int s : state)
            if (s != 2) return false;

        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int node) {
        if (state[node] == 1)   return true;
        if (state[node] == 2)   return false;

        state[node] = 1;
        System.out.println(Arrays.toString(adj));

        for (int i : adj[node]) {
            if (adj[i].contains(node)) {
                adj[i].remove(Integer.valueOf(node));
            }
            if (hasCycle(adj, i))   return true;
        }

        state[node] = 2;
        return false;
    }
}
