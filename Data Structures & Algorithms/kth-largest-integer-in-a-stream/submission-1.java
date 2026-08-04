class KthLargest {
    Queue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int n : nums) {
            if (minHeap.size() == k) {
                int currKth = minHeap.poll();
                int addedValue = Math.max(currKth, n);
                minHeap.add(addedValue);
            } else {
                minHeap.add(n);
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.isEmpty()) {
            minHeap.add(val);
            return val;
        }
        int currKth = minHeap.poll();
        if (currKth < val) {
            minHeap.add(val);
        } else {
            minHeap.add(currKth);
        }
        int res = minHeap.poll();
        minHeap.add(res);
        return res;
    }
}
