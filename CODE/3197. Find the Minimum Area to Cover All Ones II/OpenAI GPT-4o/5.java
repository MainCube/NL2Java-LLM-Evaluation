class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Identify all 1's in the grid
        List<int[]> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                }
            }
        }
        
        int size = ones.size();
        if (size < 3) return 0; // Because there should be at least 3 ones
        
        // Step 2: Generate all possible rectangles that can cover any subset of 1's
        List<int[][]> rectangles = new ArrayList<>();
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int i2 = i1; i2 < n; i2++) {
                    for (int j2 = j1; j2 < m; j2++) {
                        List<int[]> covered = new ArrayList<>();
                        for (int[] one : ones) {
                            if (i1 <= one[0] && one[0] <= i2 && j1 <= one[1] && one[1] <= j2) {
                                covered.add(one);
                            }
                        }
                        if (!covered.isEmpty()) {
                            rectangles.add(new int[][]{{i1, j1}, {i2, j2}, {covered.size()}});
                        }
                    }
                }
            }
        }
        
        // Step 3: DP approach to find minimum sum of areas of 3 non-overlapping rectangles
        int[][][] dp = new int[size + 1][size + 1][size + 1];
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;

        for (int[][] rect1 : rectangles) {
            int area1 = (rect1[1][0] - rect1[0][0] + 1) * (rect1[1][1] - rect1[0][1] + 1);
            int covered1 = rect1[2][0];
            for (int[][] rect2 : rectangles) {
                int area2 = (rect2[1][0] - rect2[0][0] + 1) * (rect2[1][1] - rect2[0][1] + 1);
                int covered2 = rect2[2][0];
                if (rectanglesOverlap(rect1, rect2)) continue;
                for (int[][] rect3 : rectangles) {
                    int area3 = (rect3[1][0] - rect3[0][0] + 1) * (rect3[1][1] - rect3[0][1] + 1);
                    int covered3 = rect3[2][0];
                    if (rectanglesOverlap(rect1, rect3) || rectanglesOverlap(rect2, rect3)) continue;
                    if (covered1 + covered2 + covered3 == size) {
                        dp[covered1][covered2][covered3] = Math.min(dp[covered1][covered2][covered3], area1 + area2 + area3);
                    }
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                for (int k = 0; k <= size; k++) {
                    if (i + j + k == size) {
                        minSum = Math.min(minSum, dp[i][j][k]);
                    }
                }
            }
        }

        return minSum;
    }

    private boolean rectanglesOverlap(int[][] rect1, int[][] rect2) {
        return !(rect1[1][0] < rect2[0][0] || rect2[1][0] < rect1[0][0] || rect1[1][1] < rect2[0][1] || rect2[1][1] < rect1[0][1]);
    }
}