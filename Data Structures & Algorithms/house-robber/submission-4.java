class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        if (nums.length == 1)   return nums[0];
        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dfs(nums, 2);
        return dp[nums.length - 1];
    }

    private void dfs(int[] nums, int i) {
        if (i >= nums.length)   return;
        if (dp[i] != 0) return;
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        dfs(nums, i + 1);
    }
}
