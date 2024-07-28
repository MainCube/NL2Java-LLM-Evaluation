class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through the grid to find the min and max row and column indices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }

        // Calculate the dimensions of the rectangle
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        // Return the area of the rectangle
        return height * width;
    }
}