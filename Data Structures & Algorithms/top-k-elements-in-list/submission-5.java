class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            list.add(new ArrayList<>());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            int freq = map.get(n);
            list.get(freq).add(n);
        }

        int[] result = new int[k];
        int i = 0;
        for (int j = nums.length; j >= 0; j--) {
            List<Integer> curr = list.get(j);
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
