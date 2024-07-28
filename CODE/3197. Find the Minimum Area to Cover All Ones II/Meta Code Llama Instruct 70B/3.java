class Solution {
    public int minimumSum(int[][] grid) {
        return minimumSum(grid, 0, 0, grid.length, grid[0].length);
    }

    private int minimumSum(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart == rowEnd || colStart == colEnd) {
            return 0;
        }

        // Find the row with the most number of ones
        int maxRow = rowStart;
        for (int row = rowStart + 1; row < rowEnd; row++) {
            int count = 0;
            for (int col = colStart; col < colEnd; col++) {
                if (grid[row][col] == 1) {
                    count++;
                }
            }
            if (count > colEnd - colStart) {
                maxRow = row;
                break;
            }
        }

        // Find the minimum sum for the top part
        int topSum = minimumSum(grid, rowStart, colStart, maxRow, colEnd);

        // Find the minimum sum for the bottom part
        int bottomSum = minimumSum(grid, maxRow, colStart, rowEnd, colEnd);

        // Combine the results to find the minimum sum
        int minSum = Integer.MAX_VALUE;
        for (int topRow = rowStart; topRow < maxRow; topRow++) {
            for (int bottomRow = maxRow; bottomRow < rowEnd; bottomRow++) {
                int topArea = (bottomRow - topRow) * (colEnd - colStart);
                int bottomArea = (rowEnd - bottomRow) * (colEnd - colStart);
                int sum = topSum + bottomSum + topArea + bottomArea;
                minSum = Math.min(minSum, sum);
            }
        }

        return minSum;
    }
}
