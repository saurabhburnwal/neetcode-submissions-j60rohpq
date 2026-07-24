class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int i) {
        if (set.size() == nums.length) {
            if (!res.contains(set))
                res.add(new ArrayList<>(set));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!visited.contains(j)) {
                set.add(nums[j]);
                visited.add(j);
                dfs(nums, j + 1);
                set.remove(set.size() - 1);
                visited.remove(j);
            }
        }
    }
}
