class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int index, String s, List<String> curr, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            StringBuilder b = new StringBuilder(s.substring(index, i));
            if (b.reverse().toString().equals(s.substring(index, i))) {
                curr.add(s.substring(index, i));
                backtrack(i, s, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
