class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, maxWater = 0, n = heights.length;
        
        while (l < r) {

            int water = (r - l) * Math.min(heights[l], heights[r]);
            maxWater = Math.max(water, maxWater);

            if (heights[r] >= heights[l])   l++;
            else    r--;
        }

        return maxWater;
    }
}
