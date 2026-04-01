class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int len = s.length();
        int j = len - 1;
        int n = (int) Math.ceil(len / 2);

        if (s.trim() == "") return true;

        while (n != 0 && i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i)) || Character.isWhitespace(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j)) || Character.isWhitespace(s.charAt(i))) {
                j--;
                continue;
            }
            if (!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))) 
                return false;
            n--;
            i++;
            j--;
        }
        return true;
    }
}
