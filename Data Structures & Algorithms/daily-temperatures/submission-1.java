class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int i = 0;
        Stack<Integer> s = new Stack<>();
        while (i < temperatures.length) {
            int n = temperatures[i];
            while (!s.isEmpty() && n > s.peek()) {
                s.pop();
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
            s.push(n);
            i++;
        }
        return result;
    }
}
