class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            maxHeap.offer(new int[] {key, map.get(key)});
        }
        int[] res = new int[k];
        while (k > 0) {
            res[k - 1] = maxHeap.poll()[0];
            k--;
        }
        return res;
    }
}
