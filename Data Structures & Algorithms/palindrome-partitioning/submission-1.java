class Solution {
    private List<List<String>> res;
    private List<String> set;
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                dp[i][i + l - 1] = s.charAt(i) == s.charAt(i + l - 1) &&
                                   ((i + 1) > (i + l - 2) ||
                                   dp[i + 1][i + l - 2]);
            }
        }
        res = new ArrayList<>();
        set = new ArrayList<>();
        dfs(s, 0, dp);
        return res;
    }

    private void dfs(String s, int i, boolean[][] dp) {
        if (i >= s.length())
            res.add(new ArrayList<>(set));
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                set.add(s.substring(i, j + 1));
                dfs(s, j + 1, dp);
                set.remove(set.size() - 1);
            }
        }
    }
}
// 0 1 2 3 4
// a a b a a

// l = 1
// dp[0][0] = 'a' == 'a' && (1 > -1) || dp[1][-1] -> 1
// dp[1][1] = 'a' == 'a' && (2 > 0) || dp[2][0] -> 1
// dp[2][2] = 'b' == 'b' && (3 > 1) || dp[3][1] -> 1
// dp[3][3] = 'a' == 'a' && (4 > 2) || dp[4][2] -> 1
// dp[4][4] = 'a' == 'a' && (5 > 3) || dp[5][3] -> 1

// l = 2
// dp[0][1] = 'a' == 'a' && (1 > 0) || dp[1][0] -> 1
// dp[1][2] = 'a' == 'b' && (2 > 1) || dp[2][1] -> 0
// dp[2][3] = 'b' == 'a' && (3 > 2) || dp[3][2] -> 0
// dp[3][4] = 'a' == 'a' && (4 > 3) || dp[4][3] -> 1

// l = 3
// dp[0][2] = 'a' == 'b' && (1 > 1) || dp[1][1] -> 0
// dp[1][3] = 'a' == 'a' && (2 > 2) || dp[2][1] -> 1
// dp[2][4] = 'b' == 'a' && (3 > 2) || dp[3][2] -> 0

// l = 4
// dp[0][3] = 'a' == 'a' && (1 > 2) || dp[1][2] -> 0
// dp[1][4] = 'a' == 'a' && (2 > 3) || dp[2][3] -> 0

// l = 5
// dp[0][4] = 'a' == 'a' && (1 > 3) || dp[1][3] -> 1


// dp = [
//     [1 1 0 0 1],
//     [0 1 0 1 0],
//     [0 0 1 0 0],
//     [0 0 0 1 1],
//     [0 0 0 0 1]
// ]
