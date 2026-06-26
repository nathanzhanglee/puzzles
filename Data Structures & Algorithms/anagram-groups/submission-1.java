class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] curr = new int[26];
            for (char c : s.toCharArray()) {
                curr[c - 'a']++;
            }
            String key = Arrays.toString(curr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
