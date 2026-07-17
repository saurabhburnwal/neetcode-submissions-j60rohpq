class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    int count;
    int left;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
        count = 0;
        left = 0;
    }
    
    public void addNum(int num) {
        max.offer(num);
        count++;
        left = (count % 2 != 0) ? 
            (count + 1) / 2 : 
            count / 2 + 1;

        if (max.size() > left) {
            min.offer(max.poll());
        } else if (!min.isEmpty()) {
            if (max.peek() > min.peek()) {
                int temp1 = max.poll();
                int temp2 = min.poll();
                min.offer(temp1);
                max.offer(temp2);
            }
        }
    }
    
    public double findMedian() {
        double ans;
        if (count % 2 != 0) {
            ans = (double) max.peek();
        } else {
            int temp = max.poll();
            ans = (max.peek() + temp) / 2.0;
            max.offer(temp);
        }
        return ans;
    }
}
// 5
// c -> 1
// l -> c+1 / 2 = 1
// max = 5

// 3
// c -> 2
// l -> c / 2 + 1 = 2
// max = 5,3

// 7
// c -> 3
// l -> c+1 / 2 = 2
// max = 5,3
// min = 7

// 2
// c -> 4
// l -> c / 2 + 1 = 3
// 
