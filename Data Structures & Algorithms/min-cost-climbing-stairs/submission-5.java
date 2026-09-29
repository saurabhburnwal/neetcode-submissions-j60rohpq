class Solution {
    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        dfs(cost, cost.length - 1);
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    private int dfs(int[] cost, int node) {
        if (node < 0)  return 0;
        if (dp[node] != 0)  return dp[node];
        return dp[node] = cost[node] + Math.min(dfs(cost, node - 1), dfs(cost, node - 2));
    }
}
