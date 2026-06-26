class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer>[] result = new ArrayList[nums.length + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = new ArrayList<>();
        }
        for (int key : freq.keySet()) {
            ArrayList<Integer> curr = result[freq.get(key)];
            curr.add(key);
        }
        int[] res = new int[k];
        int i = nums.length;
        int index = 0;
        while (index != k) {
            ArrayList<Integer> curr = result[i];
            int size = curr.size();
            for (int j = 0; j < size; j++) {
                res[index + j] = curr.get(j);
            }
            index += size;
            i--;
        }
        return res;
    }
}
