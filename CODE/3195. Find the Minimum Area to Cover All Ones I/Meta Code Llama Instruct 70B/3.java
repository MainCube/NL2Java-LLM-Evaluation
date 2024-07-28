class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] leftmost = new int[m], rightmost = new int[m];

        // Initialize leftmost and rightmost arrays
        for (int i = 0; i < m; i++) {
            leftmost[i] = -1;
            rightmost[i] = n;
        }

        // Update leftmost positions of 1s for each row
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    leftmost[i] = Math.max(leftmost[i], j);
                }
            }
        }

        // Update rightmost positions of 1s for each row
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    rightmost[i] = Math.min(rightmost[i], j);
                }
            }
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (leftmost[i] != -1 && rightmost[i] != n) {
                for (int j = i; j < m; j++) {
                    if (leftmost[j] != -1 && rightmost[j] != n) {
                        int width = rightmost[i] - leftmost[j] + 1;
                        int height = j - i + 1;
                        minArea = Math.min(minArea, width * height);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
