class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0)
                maxHeap.offer(cnt);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll() - 1;
                if (curr > 0)
                    q.offer(new int[] {curr, time + n});
            }
            if (!q.isEmpty() && time == q.peek()[1]) {
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

// ["X","X","X","Y","Y"], n = 2

// count[c - 'A']++;

// count[23] = 3
// count[24] = 2

// maxHeap = 

// q = []

// time = 1ms + 1ms + idle(1ms) + 1ms + 1ms + idle(1ms) + 1ms = 7ms
