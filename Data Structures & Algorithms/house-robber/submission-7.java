class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length)   return 0;
        if (dp[i] != 0) return dp[i];
        return dp[i] = Math.max(nums[i] + dfs(nums, i + 2), dfs(nums, i + 1));
    }
}

// [2,9,8,6,3]
