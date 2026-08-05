class Solution {
    List<List<String>> res;
    List<String> set;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        set = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(set));
        }

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (palindrome(sub)) {
                set.add(sub);
                dfs(s, j + 1);
                set.remove(set.size() - 1);
            }
        }
    }

    public boolean palindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
