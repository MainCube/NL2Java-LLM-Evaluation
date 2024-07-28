import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumSum(int[][] grid) {
        List<int[]> ones = new ArrayList<>();
        
        // Collect all coordinates of 1's in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                }
            }
        }
        
        int n = ones.size();
        int minSum = Integer.MAX_VALUE;

        // Try all possible combinations to split the 1's into 3 non-overlapping sets
        for (int i = 1; i < (1 << n); i++) {
            for (int j = i + 1; j < (1 << n); j++) {
                if ((i & j) != 0) continue;  // Ensure non-overlapping sets
                
                int[] rect1 = getRectArea(ones, i);
                int[] rect2 = getRectArea(ones, j);
                int[] rect3 = getRectArea(ones, ((1 << n) - 1) ^ (i | j));
                
                if (rect1[0] != -1 && rect2[0] != -1 && rect3[0] != -1) {
                    int totalArea = rect1[0] * rect1[1] + rect2[0] * rect2[1] + rect3[0] * rect3[1];
                    minSum = Math.min(minSum, totalArea);
                }
            }
        }
        
        return minSum;
    }

    private int[] getRectArea(List<int[]> ones, int mask) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        boolean found = false;

        for (int k = 0; k < ones.size(); k++) {
            if ((mask & (1 << k)) != 0) {
                found = true;
                int[] coord = ones.get(k);
                minX = Math.min(minX, coord[0]);
                minY = Math.min(minY, coord[1]);
                maxX = Math.max(maxX, coord[0]);
                maxY = Math.max(maxY, coord[1]);
            }
        }
        
        if (!found) return new int[]{-1, -1};
        
        return new int[]{maxX - minX + 1, maxY - minY + 1};
    }
}