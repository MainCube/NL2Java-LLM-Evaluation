class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int top = m, left = n, bottom = 0, right = 0;

        // Find the top-left corner
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    left = Math.min(left, j);
                }
            }
        }

        // Find the bottom-right corner
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    bottom = i;
                    right = Math.max(right, j);
                }
            }
        }

        // Calculate the area
        int height = bottom - top + 1;
        int width = right - left + 1;
        return height * width;
    }
}
