class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (max.size() == min.size()) {
            if (min.size() > 0 && min.peek() < num) {
                max.offer(min.poll());
                min.offer(num);
            } else {
                max.offer(num);
            }
        } else {
            if (max.peek() > num) {
                min.offer(max.poll());
                max.offer(num);
            } else {
                min.offer(num);
            }
        }
    }

    public double findMedian() {
        if (min.size() - max.size() == 0) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return (double) max.peek();
        }
    }
}
