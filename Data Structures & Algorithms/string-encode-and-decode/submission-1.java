class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return res;
    }
}
