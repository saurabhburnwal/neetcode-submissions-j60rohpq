class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        int[] arr = new int[128];

        for (char c : t.toCharArray()) {
            arr[c]++;
        }

        int res = s.length() + 1;
        int start = -1;

        for (int l = 0; l < s.length(); l++) {

            int count = t.length();
            int[] cpy = arr.clone();

            for (int r = l; r < s.length(); r++) {

                char c = s.charAt(r);

                if (cpy[c] > 0) {
                    count--;
                }

                cpy[c]--;

                if (count == 0) {
                    if (r - l + 1 < res) {
                        res = r - l + 1;
                        start = l;
                    }
                    break;
                }
            }
        }

        return start == -1 ? "" : s.substring(start, start + res);
    }
}