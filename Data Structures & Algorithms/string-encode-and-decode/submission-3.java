class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs) {
            result += s.length() + "#" + s; // do i need to include original ""
        }
        return result;
    }
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int size = 0;
            while (str.charAt(i) != '#') { // how to convert chars to digit
                size *= 10;
                size += str.charAt(i) - '0';
                i++;
            }
            i++;
            result.add(str.substring(i, i + size));
            i += size;
        }
        return result;
    }
}
