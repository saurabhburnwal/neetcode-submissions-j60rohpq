class Solution {
    private int[] state;

    public boolean canFinish(int numCourses, int[][] pre) {

        if (pre.length == 0)    return true;
        
        List[] adj = new ArrayList[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] entry : pre) {
            adj[entry[0]].add(entry[1]);
        }

        state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(adj, i))
                return false;
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int v) {

        if (state[v] == 1)  return true;
        if (state[v] == 2)  return false;

        state[v] = 1;

        for (int i : adj[v]) {
            if (hasCycle(adj, i))   return true;
        }
        
        state[v] = 2;

        return false;
    }
}
