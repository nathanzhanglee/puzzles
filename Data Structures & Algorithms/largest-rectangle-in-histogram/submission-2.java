class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = Integer.MIN_VALUE;
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!s.isEmpty() && heights[i] <= s.peek()[1]) {
                int[] curr = s.pop();
                int length = i - curr[0];
                result = Math.max(result, length * curr[1]);
                index = curr[0];
            }
            s.push(new int[] {index, heights[i]});
        }
        while (!s.isEmpty()) {
            int[] curr = s.pop();
            result = Math.max(result, (heights.length - curr[0]) * curr[1]);
        }
        return result;
    }
}
