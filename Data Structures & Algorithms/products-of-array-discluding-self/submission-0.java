class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] *= prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
}  
