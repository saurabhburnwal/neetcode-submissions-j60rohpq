class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        if (nums.length == 1)   return nums[0];
        dp = new int[nums.length];
        int a = dfs(nums, 0, true);
        dp = new int[nums.length];
        int b = dfs(nums, 1, false);
        return Math.max(a, b);
    }

    private int dfs(int[] nums, int i, boolean flag) {
        if (i >= nums.length || (flag && i == nums.length - 1)) return 0;
        if (dp[i] != 0) return dp[i];
        return dp[i] = Math.max(nums[i] + dfs(nums, i + 2, flag), dfs(nums, i + 1, flag));
    }
}
