class Solution {
    private Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        map = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );

        dfs(digits, 0, res, new StringBuilder(""));
        return res;
    }

    private void dfs(String digits, int i, List<String> res, StringBuilder set) {
        if (i >= digits.length()) {
            res.add(set.toString());
            return;
        }

        List<Character> it = map.get(digits.charAt(i));

        for (Character c : it) {
            set.append(c);
            dfs(digits, i + 1, res, set);
            set.deleteCharAt(set.length() - 1);
        }
    }
}
