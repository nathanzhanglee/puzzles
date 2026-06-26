class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            maxHeap.add(n);
        }
        while (maxHeap.size() > 1) {
            int weight1 = maxHeap.poll();
            int weight2 = maxHeap.poll();
            if (weight1 == weight2) {
                continue;
            }
            maxHeap.add(Math.max(weight1, weight2) - Math.min(weight1, weight2));
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        } else {
            return 0;
        }
    }
}
