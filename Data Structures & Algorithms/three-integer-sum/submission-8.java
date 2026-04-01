class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();

        for (int pivot = 0; pivot < nums.length - 1; pivot++) {

            if (nums[pivot] > 0)    break;
            if (pivot > 0 && nums[pivot] == nums[pivot - 1])    continue;

            int left = pivot + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[pivot];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    if (!out.contains(Arrays.asList(nums[pivot], nums[left], nums[right])))
                        out.add(Arrays.asList(nums[pivot], nums[left], nums[right]));
                    right--;
                    left++;
                }
            }
        }
        return out;
    }
}
