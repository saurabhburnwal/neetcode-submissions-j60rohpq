class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Arrays.setAll(adj, i -> new ArrayList<>());
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int[] idg = new int[numCourses];
        
        for (int[] edge : pre)
            adj[edge[0]].add(edge[1]);
            
        for (ArrayList<Integer> list : adj) {
            for (int i : list) {
                idg[i]++;
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (idg[i] == 0) q.offer(i);
        }
                
        while (!q.isEmpty()) {
            
            int ele = q.poll();
            res.add(ele);
            for (int i : adj[ele]) {
                idg[i]--;
                if (idg[i] == 0)    q.offer(i);
            }
        }
        
        if (res.size() == numCourses)   return true;
        return false;
    }
}
