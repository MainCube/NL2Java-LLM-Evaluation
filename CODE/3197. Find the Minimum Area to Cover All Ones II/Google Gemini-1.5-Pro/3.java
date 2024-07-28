class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowSum = new int[m]; // Store the number of 1's in each row
        int[] colSum = new int[n]; // Store the number of 1's in each column

        // Calculate rowSum and colSum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }

        // Find the minimum area using 3 rectangles: one for rows, one for columns, and one for the overlap
        return getArea(rowSum) + getArea(colSum) - getOverlapArea(grid);
    }

    // Helper function to calculate the minimum area covered by rectangles for a single row or column
    private int getArea(int[] arr) {
        int area = 0, numRect = 0;
        for (int val : arr) {
            if (val > 0) {
                area += val;
                numRect++;
            }
        }
        // If only one continuous segment of 1's, we need an additional rectangle of area 1
        return numRect <= 1 ? area : area + numRect - 1; 
    }

    // Helper function to calculate the area of overlap between row and column rectangles
    private int getOverlapArea(int[][] grid) {
        int overlap = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // If a cell is 1, it contributes to both row and column rectangles, hence an overlap
                    overlap++; 
                }
            }
        }
        return overlap;
    }
}