class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int count = s1.length();
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            if (arr[c - 'a'] > 0)  count--;
            arr[c - 'a']--;

            if (r - l + 1 > s1.length()) {
                char d = s2.charAt(l);
                if (arr[d - 'a'] >= 0)  count++;
                arr[d - 'a']++;
                l++;
            }

            if (count == 0) return true;
        }
        return false;
    }
}
