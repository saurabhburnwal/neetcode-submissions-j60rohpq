class Solution {
    private int[] res;
    private int[] state;
    private int size;

    public int[] findOrder(int num, int[][] pre) {

        List<Integer>[] adj = new ArrayList[num];
        Arrays.setAll(adj, i -> new ArrayList<>());

        res = new int[num];
        state = new int[num];
        size = 0;

        for (int[] edge : pre)  adj[edge[0]].add(edge[1]);
 
        for (int i = 0; i < num; i++) {
            if (dfs(adj, i))    return new int[0];
        }
        
        return res;
    }

    private boolean dfs(List<Integer>[] adj, int node) {
        
        if (state[node] == 1)  return true;
        if (state[node] == 2)    return false;
        
        state[node] = 1;

        for (int i : adj[node])
            if (dfs(adj, i))    return true;

        state[node] = 2;
        res[size++] = node;
        adj[node] = new ArrayList<>();
        
        return false;
    }
}
