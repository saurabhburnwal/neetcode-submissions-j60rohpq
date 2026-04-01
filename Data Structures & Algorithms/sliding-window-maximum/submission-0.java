class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> d = new LinkedList<>();
        
        int l, r;
        l = r = 0;
        int[] out = new int[nums.length - k + 1];

        while (r < nums.length) {
            while (!d.isEmpty() && nums[r] > nums[d.peekLast()]) {
                d.removeLast();
            }
            d.addLast(r);

            if (l > d.peekFirst()) {
                d.removeFirst();
            }

            if ((r + 1) >= k) {
                out[l] = nums[d.peekFirst()];
                l++;
            }
            r++;
        }

        return out;
    }
}
