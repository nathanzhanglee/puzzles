class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {
            HashMap<Character, Integer> curr = new HashMap<>();
            for (char c : s.toCharArray()) {
                curr.put(c, curr.getOrDefault(c, 0) + 1);
            }
            if (map.containsKey(curr)) {
                map.get(curr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(curr, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> m : map.keySet()) {
            result.add(map.get(m));
        }
        return result;
    }
}
