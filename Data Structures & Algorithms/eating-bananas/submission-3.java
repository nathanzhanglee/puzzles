class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            for (int n : piles) {
                totalHours += Math.ceil((double) n / mid);
            }
            if (totalHours <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
