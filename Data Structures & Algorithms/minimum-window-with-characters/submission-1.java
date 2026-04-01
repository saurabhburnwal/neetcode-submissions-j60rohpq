class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        int arr[] = new int[128];
        int l = 0;
        int r = 0;

        for(char c: t.toCharArray()){
            arr[c]++;
        }

        int start = -1;
        int min = s.length() + 1;
        int count = t.length();
        while(r < s.length()){
            char c = s.charAt(r);
            if(arr[c] > 0) count--;
            arr[c]--;

            while(count == 0) {
                 if(r - l + 1 < min){
                    min = r - l + 1;
                    start = l;
                }
                char left = s.charAt(l);
                if(arr[left] >= 0) count++;
                arr[left]++;
                l++;
            }
            r++;
        }
        if(start == -1) return "";
        return s.substring(start , start + min);
    }
}