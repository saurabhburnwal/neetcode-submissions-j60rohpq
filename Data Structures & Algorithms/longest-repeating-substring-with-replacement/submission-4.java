class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l, r, maxFreq, res;
        l = r = maxFreq = res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));
            if (r - l + 1 - maxFreq <= k) {
                res = Math.max(r - l + 1, res);
            } else {
                char d = s.charAt(l);
                freq.put(d, freq.getOrDefault(d, 0) - 1);
                l++;
            }
            r++;
        }
        return res;
    }
}
