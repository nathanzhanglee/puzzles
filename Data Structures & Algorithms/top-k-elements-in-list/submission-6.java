class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int num : freq.keySet()) {
            list.get(freq.get(num)).add(num);
        }
        int[] result = new int[k];
        int i = 0;
        for (int j = nums.length; j >= 0; j--) {
            ArrayList<Integer> curr = list.get(j);
            for (int n : curr) {
                result[i] = n;
                i++;
                if (i == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
