class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                if (i != p) swap(nums, p, i);
                p++;
            }
        }
        
        swap(nums, p, right);

        if (p > k) {
            return quickSelect(nums, left, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, right, k);
        } else {
            return nums[k];
        }
    }
    
    private void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
