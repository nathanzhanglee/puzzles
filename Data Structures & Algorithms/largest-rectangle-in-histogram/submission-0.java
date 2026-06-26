class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!s.isEmpty() && heights[i] < s.peek()[1]) {
                index = s.peek()[0];
                int height = s.pop()[1];
                int width = i - index;
                res = Math.max(res, height * width);
            }
            s.push(new int[] {index, heights[i]});
        }
        while(!s.isEmpty()) {
            int index = s.peek()[0];
            int height = s.pop()[1];
            int width = heights.length - index;
            res = Math.max(res, height * width);
        }
        return res;
    }
}
