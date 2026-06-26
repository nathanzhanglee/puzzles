class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void helper(String s, int index, List<String> curr, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (s.substring(index, i).equals(new StringBuilder(s.substring(index, i)).reverse().toString())) {
                curr.add(s.substring(index, i));
                helper(s, i, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
