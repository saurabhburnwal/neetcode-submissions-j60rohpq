class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) return 1;
        if (n < 0)  return 0;
        if (cache[n] != 0)  return cache[n];
        
        return cache[n] = dfs(n - 1) + dfs(n - 2);
    }
}
