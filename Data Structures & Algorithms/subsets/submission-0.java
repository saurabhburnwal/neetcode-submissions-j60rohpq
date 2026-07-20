class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        
        set.add(nums[i]);
        dfs(nums, i + 1);

        set.remove(set.size() - 1);
        dfs(nums, i + 1);
        
    }
}
