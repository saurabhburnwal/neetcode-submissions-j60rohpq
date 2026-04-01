class Solution {
    public boolean isPalindrome(String s) {
        int first = 0;
        int len = s.length();
        int last = len - 1;

        // if (s.trim() == "") return true;

        while (first < last) {
            if (!Character.isLetterOrDigit(s.charAt(first)) || Character.isWhitespace(s.charAt(first))) {
                first++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(last)) || Character.isWhitespace(s.charAt(last))) {
                last--;
                continue;
            }
            if (!String.valueOf(s.charAt(first)).equalsIgnoreCase(String.valueOf(s.charAt(last)))) 
                return false;
            first++;
            last--;
        }
        return true;
    }
}
