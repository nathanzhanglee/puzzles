class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (String curr: strs) {
            int length = curr.length();
            s.append("" + length + "#" + curr);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int length = 0;
            while (str.charAt(i) != '#') {
                length *= 10;
                length += str.charAt(i) - '0';
                i++;
            }
            i++;
            res.add(str.substring(i, i + length));
            i += length - 1;
        }
        return res;
    }
}
