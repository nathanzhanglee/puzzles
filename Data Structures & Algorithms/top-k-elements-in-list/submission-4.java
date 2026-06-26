class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int n : freq.keySet()) {
            q.add(new int[] {n, freq.get(n)});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.poll()[0];
        }
        return result;
    }
}
