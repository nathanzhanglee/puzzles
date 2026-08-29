class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            maxHeap.offer(s);
        }
        while (maxHeap.size() >= 2) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (second != first) {
                int max = Math.max(first, second);
                int min = Math.min(first, second);
                maxHeap.offer(max - min);
            }
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        }
        return 0;
    }
}
