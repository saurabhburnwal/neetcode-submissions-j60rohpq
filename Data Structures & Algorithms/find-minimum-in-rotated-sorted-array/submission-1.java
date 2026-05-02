class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (l == r || nums[l] < nums[r]) return nums[l];
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            min = Math.min(min, Math.min(nums[l], nums[r]));
            if (nums[l] < nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return min;
    }
}
