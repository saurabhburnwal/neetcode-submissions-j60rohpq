class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }
    
    public void dfs(int[] nums, int target, int i, int sum) {
        if (i >= nums.length) {
            if (sum == target)
                    res.add(new ArrayList<>(set));
            return;
        }

        if (sum > target)   return;

        set.add(nums[i]);
        dfs(nums, target, i, sum + nums[i]);

        set.remove(set.size() - 1);
        dfs(nums, target, i + 1, sum);
    }
}
