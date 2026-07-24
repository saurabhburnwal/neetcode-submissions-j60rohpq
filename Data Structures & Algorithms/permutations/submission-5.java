class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (set.size() == nums.length) {
        res.add(new ArrayList<>(set));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (set.contains(nums[j]))   continue;
            set.add(nums[j]);
            dfs(nums);
            set.remove(set.size() - 1);
        }
    }
}
    
