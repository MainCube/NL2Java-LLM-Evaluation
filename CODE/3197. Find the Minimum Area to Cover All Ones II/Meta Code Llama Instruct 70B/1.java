class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] rects = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rects[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int left = j, right = j, top = i, bottom = i;

                    while (left >= 0 && rects[i][left] == 1) {
                        left--;
                    }
                    while (right < n && rects[i][right] == 1) {
                        right++;
                    }
                    while (top >= 0 && rects[top][j] == 1) {
                        top--;
                    }
                    while (bottom < m && rects[bottom][j] == 1) {
                        bottom++;
                    }

                    ans = Math.min(ans, (right - left - 1) * (bottom - top - 1));
                    for (int k = top + 1; k < bottom; k++) {
                        for (int l = left + 1; l < right; l++) {
                            rects[k][l] = 0;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
