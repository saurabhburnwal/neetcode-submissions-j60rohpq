class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void dfs(List<Integer> set, int[] nums, boolean[] visited) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                set.add(nums[i]);
                visited[i] = true;
                dfs(set, nums, visited);
                set.remove(set.size() - 1);
                visited[i] = false;
            }
        }
    }
}
