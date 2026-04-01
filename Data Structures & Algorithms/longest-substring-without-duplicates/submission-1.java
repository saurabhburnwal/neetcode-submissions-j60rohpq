class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)    return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l, r, count;
        l = r = count = 0;
        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), r);
                r++;
                count = Math.max(count, r - l);
            }
            else {
                int j = l;
                if (r != s.length() -1) {
                    l = map.get(s.charAt(r)) + 1;
                    for (; j < l; j++) {
                        map.remove(s.charAt(j));
                    }
                } else {
                    return count;
                }
            }
        }
        return count;
    }
}
