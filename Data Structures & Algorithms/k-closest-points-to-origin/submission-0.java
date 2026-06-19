class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1])
        );

        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] results = new int[k][2];

        for (int i = 0; i < k; i++) {
            results[i] = pq.poll();
        }

        return results;
    }
}
