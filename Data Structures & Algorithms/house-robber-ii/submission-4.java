class Solution {
    public int rob(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < 2; i++) {
            int rob1 = 0;
            int rob2 = 0;
            for (int j = i; j <= (n - 2 + i) % n; j++) {
                int curr = Math.max(rob1 + nums[j], rob2);
                rob1 = rob2;
                rob2 = curr;
            }
            ans = Math.max(rob2, ans);
        }
        return ans;
    }
}
