class Solution {
    boolean[] vis;
    int count;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        count = 0;

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        vis = new boolean[n];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, -1});

        // System.out.println(Arrays.toString(adj));
        if (bfs(adj, q))   return false;
        
        if (count != n) return false;

        return true;

    }

    private boolean bfs(List<Integer>[] adj, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int node = temp[0];
            int parent = temp[1];
            if (vis[node]) return true;
            vis[node] = true;
            count++;
            for (int i : adj[node]) {
                if (i != parent)
                    q.offer(new int[]{i, node});
            }
        }

        return false;
    }
}
