import java.util.*;

class Solution {
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalCells = rows * cols;

        // List of all rectangles that cover at least one 1
        List<int[]> rectangles = new ArrayList<>();
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                if (grid[r1][c1] == 1) {
                    for (int r2 = r1; r2 < rows; r2++) {
                        for (int c2 = c1; c2 < cols; c2++) {
                            boolean hasOne = false;
                            int area = (r2 - r1 + 1) * (c2 - c1 + 1);
                            int bitmask = 0;
                            for (int i = r1; i <= r2; i++) {
                                for (int j = c1; j <= c2; j++) {
                                    if (grid[i][j] == 1) {
                                        hasOne = true;
                                        bitmask |= (1 << (i * cols + j));
                                    }
                                }
                            }
                            if (hasOne) {
                                rectangles.add(new int[]{bitmask, area});
                            }
                        }
                    }
                }
            }
        }

        int fullMask = (1 << totalCells) - 1;
        int[] dp = new int[1 << totalCells];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << totalCells); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            for (int[] rect : rectangles) {
                int nextMask = mask | rect[0];
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + rect[1]);
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << totalCells); mask++) {
            if (Integer.bitCount(mask) >= 3) {
                minSum = Math.min(minSum, dp[mask]);
            }
        }

        return minSum;
    }
}