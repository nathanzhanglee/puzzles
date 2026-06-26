class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();  // frequency map
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        HashMap<Integer, List<Integer>> m = new HashMap<>(); // key is frequency of list of items
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            m.putIfAbsent(frequency, new ArrayList<>());
            m.get(frequency).add(key);
        }
        int[] res = new int[k];
        int i = 0;
        int j = nums.length;
        while (i < k) {
            if (m.get(j) != null) {
                for (int n : m.get(j)) {
                    res[i] = n;
                    i++;
                }
            }
            j--;
        }
        return res;
    }
}
