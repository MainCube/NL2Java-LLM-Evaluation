import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        
        // Map to store the color of each ball
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        // Set to store distinct colors
        Set<Integer> distinctColors = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            // Update the color of the ball
            if (ballColorMap.containsKey(ball)) {
                int previousColor = ballColorMap.get(ball);
                if (previousColor != color) {
                    ballColorMap.put(ball, color);
                }
            } else {
                ballColorMap.put(ball, color);
            }
            
            // Rebuild the set of distinct colors
            distinctColors.clear();
            distinctColors.addAll(ballColorMap.values());
            
            // Store the number of distinct colors
            result[i] = distinctColors.size();
        }
        
        return result;
    }
}
