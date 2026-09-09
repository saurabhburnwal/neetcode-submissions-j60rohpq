class Solution {
    private boolean[] vis;

    public boolean canFinish(int numCourses, int[][] pre) {
        if (pre.length == 0)
            return true;
        
        List[] adj = new ArrayList[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] entry : pre) {
            adj[entry[0]].add(entry[1]);
        }

        vis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, i))
                return false;
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int v) {
        if (vis[v] == true) return true;
        if (adj[v].isEmpty())   return false;

        vis[v] = true;

        for (int i : adj[v]) {
            if (hasCycle(adj, i))    return true;
        }
        
        vis[v] = false;
        adj[v] = new ArrayList<>();
        return false;
    }
}
