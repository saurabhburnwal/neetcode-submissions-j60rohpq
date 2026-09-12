class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int size = 0;
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] edge : pre)  adj[edge[0]].add(edge[1]);

        int[] idg = new int[numCourses];

        for (ArrayList<Integer> list : adj)
            for (int v : list)  idg[v]++;

        for (int i = 0; i < numCourses; i++)
            if (idg[i] == 0)    q.offer(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            size++;
            for (int v : adj[node]) {
                idg[v]--;
                if (idg[v] == 0)    q.offer(v);
            }
        }

        return size == numCourses;
    }
}
