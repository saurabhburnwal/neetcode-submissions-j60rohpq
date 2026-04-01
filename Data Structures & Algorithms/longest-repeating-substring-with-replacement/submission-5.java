class Solution {
    public int characterReplacement(String s, int k) {
    int res = 0; 

    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
        map.put(ch, 0);
    }

    for (char target: map.keySet()) {
        
        int l, r, count; 
        l = r = count = 0;
    
        while(r < s.length()) {
            if(s.charAt(r) == target) {
                count++;
                } 
            if(r - l + 1 - count <= k) {
                res = Math.max(res, r - l + 1 );
            } else {
                if( s.charAt(l) == target) count--;
                l++;
                continue;
            }
            r++;
        }        
    }
    return res;
    }
}

