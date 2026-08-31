class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } 
        if (!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int temp = maxHeap.poll();
            maxHeap.offer(minHeap.poll());
            minHeap.offer(temp);
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
}
