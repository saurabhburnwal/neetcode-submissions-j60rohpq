class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for (int pivot = 0; pivot < nums.length - 1; pivot++) {
            int left = pivot + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + nums[pivot] > 0) {
                    right--;
                } else if (sum + nums[pivot] < 0) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(nums[pivot], nums[left], nums[right]);
                    if (!out.contains(list))    out.add(list);
                    right--;
                    left++;
                }
            }
        }
        return out;
    }
}
