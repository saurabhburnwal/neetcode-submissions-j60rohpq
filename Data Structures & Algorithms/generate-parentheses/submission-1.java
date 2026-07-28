class Solution {
    List<String> res;
    int[] count = new int[2];
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, sb);
        return res;
    }

    private void dfs(int n, StringBuilder sb) {
        if (n == count[0] && n == count[1]) {
            res.add(sb.toString());
        }
        
        if (count[0] < n) {
            sb.append('(');
            count[0]++;
            dfs(n, sb);
            sb.deleteCharAt(sb.length() - 1);
            count[0]--;
        }

        if (count[1] < count[0]) {
            sb.append(')');
            count[1]++;
            dfs(n, sb);
            sb.deleteCharAt(sb.length() - 1);
            count[1]--;
        }
    }
}
