class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preArr = new int[nums.length];
        int [] sufArr = new int[nums.length];
        int pre = 1;
        int suf = 1;
        for (int i = 0; i < nums.length; i++) {
            preArr[i] = pre;
            pre *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            sufArr[i] = suf;
            suf *= nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = preArr[i] * sufArr[i];
        }
        return result;
    }
}  
