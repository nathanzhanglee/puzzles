class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = 
        new PriorityQueue<>((a, b) -> ((0 - b[0]) * (0 - b[0]) + (0 - b[1]) * (0 - b[1])) - ((0 - a[0]) * (0 - a[0]) + (0 - a[1]) * (0 - a[1])));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
