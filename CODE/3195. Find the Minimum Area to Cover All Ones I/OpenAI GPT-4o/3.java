class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Initialize boundaries with a value that will be surely updated
        int minRow = rows, maxRow = -1, minCol = cols, maxCol = -1;
        
        // Traverse the grid to find the boundaries
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r < minRow) minRow = r;
                    if (r > maxRow) maxRow = r;
                    if (c < minCol) minCol = c;
                    if (c > maxCol) maxCol = c;
                }
            }
        }
        
        // Calculate the area of the smallest rectangle enclosing all 1's
        int width = maxCol - minCol + 1;
        int height = maxRow - minRow + 1;
        
        return width * height;
    }
}