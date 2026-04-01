class Solution {
    public int characterReplacement(String s, int k) {
    int res = 0;   
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
        map.put(ch, 0);
    }
    for (char target: map.keySet()) {

        for (int i = 0; i < s.length(); i++) {
            int num = k;
            int count = 0;
            int j = i;
            while (j < s.length()) {
                if (s.charAt(j) == target) {
                    count++; 
                } else {
                    if (num == 0) break;
                    count++; 
                    num--;
                }
                j++;
            }
            res = Math.max(count, res);
            }
        }
// X Y        
    return res;
    }
}