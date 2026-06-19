class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) ->
            Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1])
        );

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k)  pq.poll();
        }

        return pq.toArray(new int[0][]);
    }
}

// 2 2.8 3 k=2

//     2
// 2.8     3

// 2       2.8

//     2.8 
// 2