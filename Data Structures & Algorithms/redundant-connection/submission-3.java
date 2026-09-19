class Solution {
    String r;
    boolean flag;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (!flag)  dfs(adj, vis, i, 0, "");
        }

        System.out.println(r);
        
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == r.charAt(r.length() - 1))
                break;
            r = r.substring(1, r.length());
            i--;
        }
        
        System.out.println(r);

        for (int i = n - 2; i >= 0; i--) {
            if (r.contains(Integer.toString(edges[i][0])) &&
                r.contains(Integer.toString(edges[i][1])))
                return edges[i];
        }
        return new int[0];
    }

    private void dfs(List<Integer>[] adj, boolean[] vis, int node, int pNode, String r) {
        if (flag)   return;

        if (vis[node]) {
            r += node;
            flag = true;
            this.r = r;
            return;
        }
        vis[node] = true;
        
        for (int i : adj[node]) {
            if (pNode != i) {
                dfs(adj, vis, i, node, r + node + ",");
            }
        }
    }
}
