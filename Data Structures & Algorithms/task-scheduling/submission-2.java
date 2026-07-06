class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks)
            count[task - 'A']++;

        Arrays.sort(count);
        int maxF = count[25] - 1;
        int idle = maxF * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxF, count[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}
