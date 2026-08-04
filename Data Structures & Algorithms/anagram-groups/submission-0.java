class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashSet<Character>, List<String>> charsToIndex = new HashMap<>();
        for (String s : strs) {
            HashSet<Character> curr = new HashSet<>();
            for (char c : s.toCharArray()) {
                curr.add(c);
            }
            if (charsToIndex.containsKey(curr)) {
                charsToIndex.get(curr).add(s);
            } else {
                List<String> currList = new ArrayList<>();
                currList.add(s);
                charsToIndex.put(curr, currList);
            }
        }
        return new ArrayList<>(charsToIndex.values());
    }
}
