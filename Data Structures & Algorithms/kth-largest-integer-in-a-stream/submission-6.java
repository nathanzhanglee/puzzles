class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
        for (int n : nums) {
            if (minHeap.size() == k) {
                if (minHeap.peek() < n) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            } else {
                minHeap.offer(n);
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.isEmpty()) {
            minHeap.offer(val);
        }
        if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        } 
        return minHeap.peek();
    }
}
