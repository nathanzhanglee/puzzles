class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
       backtrack(new ArrayList<>(), s, 0, result);
       return result;
    }

    public void backtrack(List<String> curr, String s, int index, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(index, i));
            if (str.reverse().toString().equals(s.substring(index, i))) {
                curr.add(s.substring(index, i));
                backtrack(curr, s, i, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
