class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) dp[i - 1][i] = true;
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j] == true) {
                    if (j + 1 - i > res.length())    res = s.substring(i, j + 1);
                    int ni = i - 1;
                    int nj = j + 1;
                    while (ni >= 0 && nj < s.length() && s.charAt(ni) == s.charAt(nj)) {
                        dp[ni][nj] = true;
                        if (nj + 1 - ni > res.length())   res = s.substring(ni, nj + 1);
                        ni--;
                        nj++;
                    }
                }
            }
        }
        // for (boolean[] d : dp)  System.out.println(Arrays.toString(d));
        return res;
    }
}

// [true, true, true, true, false]
// [false, true, true, true, true]
// [false, false, true, true, true]
// [false, false, false, true, true]
// [false, false, false, false, true]