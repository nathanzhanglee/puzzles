class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int left = 1;
       int right = Integer.MIN_VALUE;
       int result = Integer.MAX_VALUE;
       for (int p : piles) {
        right = Math.max(right, p);
       }
       while (left <= right) {
        int mid = left + ((right - left) / 2);
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil((double) p / mid);
        }
        if (hours <= h) {
            result = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }

       }
       return result;
        
    }
}
