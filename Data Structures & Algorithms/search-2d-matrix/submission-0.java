class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midY = mid / matrix[0].length;
            int midX = mid - (midY * matrix[0].length);
            if (matrix[midY][midX] == target) {
                return true;
            } else if (matrix[midY][midX] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}


