class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = (nums[i] < 0) ? nums[i] * -1 : nums[i];
            if (nums[x] < 0)  return x;
            nums[x] *= -1;
        }
        return -1;
    }
}
