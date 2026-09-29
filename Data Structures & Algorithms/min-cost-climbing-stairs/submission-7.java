class Solution {
    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (dp[i] != 0) return dp[i];
        return dp[i] = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }
}
