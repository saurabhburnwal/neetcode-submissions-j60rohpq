class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rlen = matrix.length, clen = matrix[0].length;
        int l = 0, r = rlen * clen - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid / clen][mid % clen] == target) {
                return true;
            } else if (matrix[mid / clen][mid % clen] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
