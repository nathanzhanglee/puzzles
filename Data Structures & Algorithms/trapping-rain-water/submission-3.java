class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minOfMaxes = new int[height.length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = left;
            left = Math.max(height[i], left);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = right;
            right = Math.max(height[i], right);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            minOfMaxes[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.max(0, minOfMaxes[i] - height[i]);
        }
        return result;
    }
}
