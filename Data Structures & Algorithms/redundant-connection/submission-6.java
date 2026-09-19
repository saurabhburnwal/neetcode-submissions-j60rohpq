class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] idg = new int[n + 1];

        List<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            idg[edge[0]]++;
            idg[edge[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)    if (idg[i] == 1)    q.offer(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            idg[node]--;
            for (int i : adj[node]) {
                idg[i]--;
                if (idg[i] == 1)    q.offer(i);
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (idg[edges[i][0]] == 2 && idg[edges[i][1]] == 2)
                return edges[i];
        }

        return new int[0];
    }
}
