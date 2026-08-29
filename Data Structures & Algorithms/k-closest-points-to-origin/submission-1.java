class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> ((b[0] * b[0]) + (b[1] * b[1])) - ((a[0] * a[0]) + (a[1] * a[1])));
        for (int[] point : points) {
            if (maxHeap.size() == k) {
                int[] max = maxHeap.peek();
                int distance = (point[0] * point[0]) + (point[1] * point[1]);
                if (((max[0] * max[0]) + (max[1] * max[1])) > distance) {
                    maxHeap.poll(); 
                    maxHeap.offer(point);
                }
            } else {
                maxHeap.offer(point);
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
