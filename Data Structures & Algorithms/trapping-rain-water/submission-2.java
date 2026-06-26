class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        // while (left < right && height[right] <= height[right - 1]) { // get to local max
        //     right--;
        // }
        // while (left < right && height[left] <= height[left + 1]) { // get to local max
        //     left++;
        // }

        while (left < right) {
            if (height[left] < height[right]) {
                int min = height[left];
                left++;
                while (left < right && height[left] <= min) {  
                    result += min - height[left];
                    left++;
                }
            } else {
                int min = height[right];
                right--;
                while (left < right && height[right] <= min) {  
                    result += min - height[right];
                    right--;
                }
            }
        }
        return result;
    }
}
