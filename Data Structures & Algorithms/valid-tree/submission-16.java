class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        int count = 0;
        boolean[] vis = new boolean[n];

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int i : adj[node]) {
                if (!vis[i]) {
                    vis[node] = true;
                    q.offer(i);
                }
            }
        }

        return count == n;

    }
}
