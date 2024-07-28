class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Find the top-most, bottom-most, left-most, and right-most 1's in the grid.
        int top = m, bottom = 0, left = n, right = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        // Calculate the area of the rectangle.
        int height = bottom - top + 1;
        int width = right - left + 1;
        return height * width;
    }
}