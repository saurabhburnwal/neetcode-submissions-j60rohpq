class Solution {
    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        dfs(cost, cost.length);
        return dp[cost.length];
    }

    private int dfs(int[] cost, int node) {
        if (node < 0)  return 0;
        if (dp[node] != 0)  return dp[node];
        if (node > 1) return dp[node] = Math.min(dfs(cost, node - 1) + cost[node - 1], dfs(cost, node - 2) + cost[node - 2]);
        return 0;
    }
}
