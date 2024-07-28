class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Find the coordinates of all '1's in the grid
        List<int[]> ones = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                }
            }
        }

        // Step 2: Iterate through all possible combinations of 3 '1's
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < ones.size(); i++) {
            for (int j = i + 1; j < ones.size(); j++) {
                for (int k = j + 1; k < ones.size(); k++) {
                    int[] p1 = ones.get(i);
                    int[] p2 = ones.get(j);
                    int[] p3 = ones.get(k);

                    // Step 3: Calculate the area covered by the 3 points
                    int area = calculateArea(p1, p2, p3);

                    // Step 4: Check if all '1's are covered by these rectangles
                    if (isCovered(grid, p1, p2, p3)) {
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea;
    }

    // Calculates the area of three rectangles formed by the three points
    private int calculateArea(int[] p1, int[] p2, int[] p3) {
        int area1 = (Math.abs(p1[0] - p2[0]) + 1) * (Math.abs(p1[1] - p2[1]) + 1); // Area of rectangle covering p1 and p2
        int area2 = (Math.abs(p2[0] - p3[0]) + 1) * (Math.abs(p2[1] - p3[1]) + 1); // Area of rectangle covering p2 and p3
        int area3 = (Math.abs(p1[0] - p3[0]) + 1) * (Math.abs(p1[1] - p3[1]) + 1); // Area of rectangle covering p1 and p3

        // Return the minimum area among the three rectangles
        return Math.min(area1, Math.min(area2, area3));
    }

    // Checks if all '1's in the grid are covered by the rectangles formed by the three points
    private boolean isCovered(int[][] grid, int[] p1, int[] p2, int[] p3) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !isPointInRectangle(i, j, p1, p2, p3)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Checks if a point (i, j) lies inside any of the rectangles formed by the three points
    private boolean isPointInRectangle(int i, int j, int[] p1, int[] p2, int[] p3) {
        return (isPointInRectangle(i, j, p1, p2) || 
                isPointInRectangle(i, j, p2, p3) || 
                isPointInRectangle(i, j, p1, p3));
    }

    // Checks if a point (i, j) lies inside the rectangle formed by two points p1 and p2
    private boolean isPointInRectangle(int i, int j, int[] p1, int[] p2) {
        int minRow = Math.min(p1[0], p2[0]);
        int maxRow = Math.max(p1[0], p2[0]);
        int minCol = Math.min(p1[1], p2[1]);
        int maxCol = Math.max(p1[1], p2[1]);
        return i >= minRow && i <= maxRow && j >= minCol && j <= maxCol;
    }
}