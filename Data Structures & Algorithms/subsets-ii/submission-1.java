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
        res.add(new ArrayList<>(set));

        for (int j = i; j < nums.length; j++) {
            if (j - i > 0 && nums[j] == nums[j - 1]) continue;
            set.add(nums[j]);
            dfs(nums, j + 1);
            set.remove(set.size() - 1);
        }
    }
}
