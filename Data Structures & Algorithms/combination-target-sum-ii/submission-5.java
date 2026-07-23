class Solution {
    List<Integer> set = new ArrayList<>();
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0, 0);
        return new ArrayList<>(res);
    }

    public void dfs(int[] nums, int target, int i, int total) {
        if (total == target) {
            res.add(new ArrayList<>(set));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            if (total + nums[j] > target) {
                return;
            }
            set.add(nums[j]);
            dfs(nums, target, j + 1, total + nums[j]);
            set.remove(set.size() - 1);
        }
    }
}
