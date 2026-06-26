class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int[] curr = new int[] {i, heights[i]};
            while (!s.isEmpty() && s.peek()[1] > curr[1]) {
                int[] prev = s.pop();
                int width = i - prev[0];
                int height = prev[1];
                max = Math.max(max, width * height);
                curr[0] = prev[0];
            }
            s.push(curr);
        }
        while (!s.isEmpty()) {
            int[] curr = s.pop();
            int width = heights.length - curr[0];
            int height = curr[1];
            max = Math.max(max, width * height);
        }
        return max;
    }
}