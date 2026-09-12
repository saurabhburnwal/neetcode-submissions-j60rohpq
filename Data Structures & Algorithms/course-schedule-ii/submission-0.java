class Solution {
    public int[] findOrder(int num, int[][] pre) {

        int[] res = new int[num];
        int size = 0;

        ArrayList<Integer>[] adj = new ArrayList[num];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : pre)  adj[edge[1]].add(edge[0]);

        int[] idg = new int[num];

        for (ArrayList<Integer> list : adj)
            for (int v : list)  idg[v]++;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < num; i++)
            if (idg[i] == 0)    q.offer(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            res[size++] = node;
            for (int v : adj[node]) {
                idg[v]--;
                if (idg[v] == 0)    q.offer(v);
            }
        }

        return (size == num) ?  res : new int[0];
    }
}
