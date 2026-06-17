class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    int capacity;
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        pq = new PriorityQueue<>();
        size = 0;
        for (int num : nums) {
            pq.offer(num);
            size++;
            if (size > capacity) {
                pq.poll();
                size--;
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        size++;
        if (size > capacity) {
            pq.poll();
            size--;
        }
        return pq.peek();
    }
}
