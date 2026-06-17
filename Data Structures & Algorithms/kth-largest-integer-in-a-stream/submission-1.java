class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    int capacity;
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > capacity) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }
}



