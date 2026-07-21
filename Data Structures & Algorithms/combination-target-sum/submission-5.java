class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int i, int total) {
        if (total == target) {
            res.add(new ArrayList<>(set));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            set.add(nums[j]);
            dfs(nums, target, j, total + nums[j]);
            set.remove(set.size() - 1);
        }
    }
}
