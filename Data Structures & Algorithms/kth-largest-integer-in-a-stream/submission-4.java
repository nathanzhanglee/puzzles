class KthLargest {
    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        this.k = k;
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
