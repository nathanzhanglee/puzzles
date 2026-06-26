class Solution {
    String[] mapping = new String[]{"", "", "a,b,c", "d,e,f", "g,h,i", "j,k,l", "m,n,o", "p,q,r,s", "t,u,v", "w,x,y,z"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        backtrack("", digits, res);
        return res;
    }
    public void backtrack(String curr, String digits, List<String> res) {
        if (digits.isEmpty()) {
            res.add(curr);
            return;
        }
        int digit = digits.charAt(0) - '0';
        String[] letters = mapping[digit].split(",");
        for (String letter : letters) {
            backtrack(curr + letter, digits.substring(1, digits.length()), res);
        }
    }
}
