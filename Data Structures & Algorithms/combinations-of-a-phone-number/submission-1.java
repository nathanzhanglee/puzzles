class Solution {
    HashMap<Integer, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        for (int i = 2; i <= 9; i ++) {
            List<Character> list = new ArrayList<>();
            if (i == 7) {
                list.add('p');
                list.add('q');
                list.add('r');
                list.add('s');

            } else if (i == 8) {
                list.add('t');
                list.add('u');
                list.add('v');
            } else if (i == 9) {
                list.add('w');
                list.add('x');
                list.add('y'); 
                list.add('z');
            } else {
                list.add((char) (((i - 2) * 3) + 'a')); 
                list.add((char) (1 + ((i - 2) * 3) + 'a')); 
                list.add((char) (2 + ((i - 2) * 3) + 'a')); 
            }
            map.put(i, list);
        }
        List<String> result = new ArrayList<>();
        backtrack("", digits, result, 0);
        return result;
    }

    public void backtrack(String curr, String digits, List<String> result, int index) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }
        for (Character c : map.get(Integer.parseInt(digits.substring(index, index + 1)))) {
            backtrack(curr + c, digits, result, index + 1);
        }
    }
}
