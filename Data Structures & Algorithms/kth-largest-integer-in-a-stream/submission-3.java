class KthLargest {
    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        this.k = k;
        for (int n : nums) {
            if (minHeap.size() == k) {
                n = Math.max(minHeap.poll(), n);
            }
            minHeap.add(n);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() == k - 1) {
            minHeap.add(val);
        } else {
            int currKth = minHeap.poll();
            minHeap.add(Math.max(val, currKth));
        }
        int res = minHeap.poll();
        minHeap.add(res);
        return res;
    }
}
