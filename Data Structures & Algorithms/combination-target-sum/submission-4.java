class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0);
        return res;
    }
    
    public void dfs(int[] nums, int target, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(set));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }

        set.add(nums[i]);
        dfs(nums, target - nums[i], i);

        set.remove(set.size() - 1);
        dfs(nums, target, i + 1);
    }
}
