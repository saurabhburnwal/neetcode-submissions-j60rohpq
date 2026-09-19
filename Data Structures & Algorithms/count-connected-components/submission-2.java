class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int count = 0;

        Queue<Integer> q = new ArrayDeque<>();
        
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    vis[node] = true;
                    for (int e : adj[node]) {
                        if (!vis[e])
                            q.offer(e);
                    }
                }
                count++;
            }
        }

        return count;
    }
}
