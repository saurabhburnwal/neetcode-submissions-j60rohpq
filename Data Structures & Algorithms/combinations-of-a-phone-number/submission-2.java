class Solution {
    private List<String> res;
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.isEmpty())   return res;
        dfs(0, "", digits);
        return res;
    }

    private void dfs(int i, String set, String digits) {
        if (set.length() == digits.length()) {
            res.add(set);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            dfs(i + 1, set + c, digits);
        }
    }
}
