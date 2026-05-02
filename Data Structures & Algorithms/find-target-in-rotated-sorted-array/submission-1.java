class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = 0;
        while (l < r) {
        int m = l + (r - l) / 2;
        if (nums[m] < nums[r])
            r = m;
        else 
            l = m + 1;
        }
        pivot = l;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[(m + pivot) % nums.length] == target) 
                return (m + pivot) % nums.length;
            else if (nums[(m + pivot) % nums.length] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}
