class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (String curr : strs) {
            int length = curr.length();
            s.append("" + length + "!" + curr);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int len = 0;
            while (Character.isDigit(str.charAt(i))) {
                len *= 10;
                len += str.charAt(i) - '0';
                i++;
            }
            i++; // skip '!'
            StringBuilder s = new StringBuilder();
            while (len > 0) {
                s.append(str.charAt(i));
                len--; 
                i++;
            }
            res.add(s.toString());
        }
        return res;
    }
}
