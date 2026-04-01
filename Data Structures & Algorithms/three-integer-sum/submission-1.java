class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left = 0, right = nums.length - 1;

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < right; i++) {
            seen.put(nums[i], i);
        }
 
        List<List<Integer>> out = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                int sum = -(nums[i] + nums[j]);
                if (seen.containsKey(sum) && seen.get(sum) != i && seen.get(sum) != j) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);
                    Collections.sort(list);
                    if (!out.contains(list))    out.add(list);
                }
            }
        }

        return out;
    }
}
