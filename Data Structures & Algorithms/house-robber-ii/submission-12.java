class Solution {
    private int[][] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return dfs(0, 0, nums);
    }

    private int dfs(int flag, int i, int[] nums) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1))
            return 0;
        if (dp[i][flag] != -1)  return dp[i][flag];
        return dp[i][flag] = Math.max(nums[i] + dfs(flag | (i == 0 ? 1 : 0), i + 2, nums), dfs(flag, i + 1, nums));
    }
}
