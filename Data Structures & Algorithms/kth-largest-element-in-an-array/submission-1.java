class Solution {
    public int findKthLargest(int[] nums, int k) {
       Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
       for (int n : nums) {
        if (minHeap.size() == k) {
            if (n > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(n);
            }
        } else {
            minHeap.offer(n);
        }
       } 
       return minHeap.poll();
    }
}
