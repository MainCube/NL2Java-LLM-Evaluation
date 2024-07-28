class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] coords = new int[m][2];
        int[] x = new int[n];
        int[] y = new int[m];

        // Find the coordinates of the first and last 1 in each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    coords[i][0] = j;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    coords[i][1] = j;
                    break;
                }
            }
        }

        // Find the minimum and maximum y-coordinates of all the 1s
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (coords[i][0] != -1) {
                minY = Math.min(minY, i);
                maxY = Math.max(maxY, i);
            }
        }

        // Find the minimum area
        int minArea = Integer.MAX_VALUE;
        for (int i = minY; i < maxY; i++) {
            // Find the maximum and minimum x-coordinates of all the 1s in the current pair of adjacent rows
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i + 1][j] == 1) {
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }

            // Calculate the area of the rectangle formed by the current pair of adjacent rows
            int area = (i + 1 - minY) * (maxX - minX + 1);
            minArea = Math.min(minArea, area);
        }

        return minArea;
    }
}
