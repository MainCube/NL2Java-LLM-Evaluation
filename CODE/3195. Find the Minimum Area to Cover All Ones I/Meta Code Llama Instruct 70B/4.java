class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Find the number of 1s in the grid
        int ones = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ones += grid[i][j];
            }
        }

        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = rows * cols;

        // Binary search on the area of the rectangle
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if there is a rectangle with this area that contains all the 1s in the grid
            if (isValid(grid, ones, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Check if there is a rectangle with the given area that contains all the 1s in the grid
    private boolean isValid(int[][] grid, int ones, int area) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Start with a rectangle with a width of 1 and gradually increase the width until we find a rectangle that contains all the 1s in the grid
        for (int width = 1; width <= Math.min(area, cols); width++) {
            int height = area / width;
            if (height * width != area) {
                continue;
            }

            // Check if there is a rectangle with the given height and width that contains all the 1s in the grid
            int count = 0;
            for (int i = 0; i < rows - height + 1; i++) {
                for (int j = 0; j < cols - width + 1; j++) {
                    if (isRectangleValid(grid, i, j, height, width)) {
                        count += height * width;
                        if (count >= ones) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    // Check if there is a rectangle with the given height and width that contains all the 1s in the grid
    private boolean isRectangleValid(int[][] grid, int i, int j, int height, int width) {
        for (int k = i; k < i + height; k++) {
            for (int l = j; l < j + width; l++) {
                if (grid[k][l] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
