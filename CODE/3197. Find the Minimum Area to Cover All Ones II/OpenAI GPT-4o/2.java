import java.util.*;

class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> ones = new ArrayList<>();
        
        // Collect all 1's positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                }
            }
        }
        
        int onesCount = ones.size();
        int allCovered = (1 << onesCount) - 1;
        int[][] dp = new int[1 << onesCount][4];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;
        
        for (int mask = 0; mask < (1 << onesCount); mask++) {
            for (int r = 0; r < 4; r++) {
                if (dp[mask][r] == Integer.MAX_VALUE) continue;
                for (int i1 = 0; i1 < m; i1++) {
                    for (int i2 = i1; i2 < m; i2++) {
                        for (int j1 = 0; j1 < n; j1++) {
                            for (int j2 = j1; j2 < n; j2++) {
                                int newMask = mask;
                                int area = (i2 - i1 + 1) * (j2 - j1 + 1);
                                for (int k = 0; k < onesCount; k++) {
                                    int[] one = ones.get(k);
                                    if (one[0] >= i1 && one[0] <= i2 && one[1] >= j1 && one[1] <= j2) {
                                        newMask |= (1 << k);
                                    }
                                }
                                if (newMask != mask && r < 3) {
                                    dp[newMask][r + 1] = Math.min(dp[newMask][r + 1], dp[mask][r] + area);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return dp[allCovered][3];
    }
}