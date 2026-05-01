class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int l = 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int hrs = 0;
            for (int pile : piles) {
                hrs += (pile + m - 1) / m;
            }
            if (hrs <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
