class Solution {
    List<List<Integer>> res;
    List<Integer> set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        set = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            if (!res.contains(set))   res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        dfs(nums, i + 1);
        set.remove(set.size() - 1);
        dfs(nums, i + 1);
    }
}
