class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSums = new int[m][n + 1];
        int[][] colSums = new int[m + 1][n];

        // Calculate the number of ones in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i][j + 1] = rowSums[i][j] + grid[i][j];
                colSums[i + 1][j] = colSums[i][j] + grid[i][j];
            }
        }

        // Initialize the answer to a large value
        int ans = Integer.MAX_VALUE;

        // Iterate over the rows and columns to find the minimum sum of the three rectangles
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i + 1; k <= m; k++) {
                    for (int l = j + 1; l <= n; l++) {
                        int sum = (rowSums[k][l] - rowSums[k][j]) - (rowSums[i][l] - rowSums[i][j]) + (colSums[k][l] - colSums[i][l]) - (colSums[k][j] - colSums[i][j]);
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }

        return ans;
    }
}
