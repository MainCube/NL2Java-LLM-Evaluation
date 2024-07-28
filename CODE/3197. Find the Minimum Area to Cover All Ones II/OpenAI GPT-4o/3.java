import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<int[]> ones = new ArrayList<>();
        
        // Step 1: Collect all positions of 1's in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ones.add(new int[]{i, j});
                }
            }
        }
        
        // Total number of ones
        int totalOnes = ones.size();
        int minSumArea = Integer.MAX_VALUE;
        
        // There are C(totalOnes, totalOnes/3) ways to split the ones into 3 groups
        // Generate all combinations where the sum of the sizes of the groups is totalOnes
        // and each group has at least one element
        for (int mask = 1; mask < (1 << totalOnes); mask++) {
            List<int[]> group1 = new ArrayList<>();
            List<int[]> group2 = new ArrayList<>();
            List<int[]> group3 = new ArrayList<>();
            
            // Distribute ones into three groups based on the bits of the mask
            int count = 0;
            for (int i = 0; i < totalOnes; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (group1.size() < totalOnes / 3) {
                        group1.add(ones.get(i));
                    } else if (group2.size() < totalOnes / 3) {
                        group2.add(ones.get(i));
                    } else {
                        group3.add(ones.get(i));
                    }
                    count++;
                }
            }
            
            if (count != totalOnes) continue;
            
            if (group1.isEmpty() || group2.isEmpty() || group3.isEmpty()) continue;
            
            int area1 = calculateArea(group1);
            int area2 = calculateArea(group2);
            int area3 = calculateArea(group3);
            
            int totalArea = area1 + area2 + area3;
            minSumArea = Math.min(minSumArea, totalArea);
        }
        
        return minSumArea;
    }
    
    private int calculateArea(List<int[]> group) {
        if (group.isEmpty()) return 0;
        
        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        
        for (int[] cell : group) {
            int row = cell[0];
            int col = cell[1];
            minRow = Math.min(minRow, row);
            maxRow = Math.max(maxRow, row);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
        }
        
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}