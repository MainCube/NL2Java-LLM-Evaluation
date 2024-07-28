class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Traverse the grid to find the boundary of '1's
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
        
        // Calculate the area of the smallest rectangle containing all '1's
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        return height * width;
    }
}