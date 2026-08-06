class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add("");
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };
        for (int i = 0; i < digits.length(); i++) {
            String chars = map[digits.charAt(i) - '0'];
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                for (char c : chars.toCharArray()) {
                    String s = res.get(j) + c;
                    tmp.add(s);
                }
            }
            res = tmp;
        }

        return res;
    }
}

// 23
// a b c
// 