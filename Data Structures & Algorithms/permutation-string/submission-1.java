class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char ch1[] = s1.toCharArray();
        Arrays.sort(ch1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            char ch2[] = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(ch2);
            if (Arrays.equals(ch1, ch2))    return true;
        }
        return false;
    }
}
