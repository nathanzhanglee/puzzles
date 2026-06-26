class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            max = Math.max(width * height, max);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
