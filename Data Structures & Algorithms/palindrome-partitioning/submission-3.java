class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, s, result);
        return result;
    }

    public void backtrack(List<String> curr, int index, String s, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(index, i));
            if (sb.reverse().toString().equals(s.substring(index, i))) {
                curr.add(s.substring(index, i));
                backtrack(curr, i, s, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
