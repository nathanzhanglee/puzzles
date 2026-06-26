class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();  // frequency map
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] counts = new List[nums.length + 1]; // index is frequency of list of items
        for (int key : freq.keySet()) {
            if (counts[freq.get(key)] == null) {
                counts[freq.get(key)] = new ArrayList<>();
            }
            counts[freq.get(key)].add(key);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] != null) {
                for (int n : counts[i]) {
                    res[j] = n;
                    j++;
                    if (j == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
