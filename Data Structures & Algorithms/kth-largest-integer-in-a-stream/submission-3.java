class KthLargest {
    PriorityQueue<Integer> pq;
    int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }
}
