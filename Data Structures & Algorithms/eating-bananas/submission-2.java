class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        int left = 1;
        int right = max;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int n : piles) {
                hours += Math.ceil((double) n / mid);
            }
            if (hours <= h) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
