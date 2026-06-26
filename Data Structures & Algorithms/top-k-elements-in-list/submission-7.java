class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            list[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int n : freq.keySet()) {
            list[freq.get(n)].add(n);
        }
        
        int[] result = new int[k];

        int i = 0;
        for (int j = nums.length; j >= 0 && i < k; j--) {
            ArrayList<Integer> curr = list[j];
            for (int n : curr) {
                result[i] = n;
                i++;
            }
        }
        return result;
    }
}
