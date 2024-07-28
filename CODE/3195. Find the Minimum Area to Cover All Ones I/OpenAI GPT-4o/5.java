class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Traverse the grid to find the bounds
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
        
        // Calculate the height and width of the rectangle
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        // Calculate the area of the rectangle
        int area = height * width;
        
        return area;
    }
}