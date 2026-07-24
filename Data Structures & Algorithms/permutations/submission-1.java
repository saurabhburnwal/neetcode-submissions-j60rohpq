class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int i) {
        if (set.size() == nums.length) {
        res.add(new ArrayList<>(set));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (set.contains(nums[j]))   continue;
            set.add(nums[j]);
            dfs(nums, j + 1);
            set.remove(set.size() - 1);
        }
    }
}
    
