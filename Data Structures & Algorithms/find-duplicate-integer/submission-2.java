class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int slow2 = 0;
        do {
            slow2 = nums[slow2];
            slow = nums[slow];
        } while (slow2 != slow);

        return slow;
    }
}
