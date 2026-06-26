class KthLargest {
    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        this.k = k;
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
        if (minHeap.size() == k - 1) {
            minHeap.add(val);
            int res = minHeap.poll();
            minHeap.add(res);
            return res;
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
