import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Dictionary to track the color of each ball
        Map<Integer, Integer> ballColors = new HashMap<>();
        // Set to track distinct colors
        Set<Integer> distinctColors = new HashSet<>();
        // Array to store the result
        int[] result = new int[queries.length];
        
        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            // Assign the color to the ball
            if (ballColors.containsKey(ball)) {
                // If the ball is recolored with a different color
                if (ballColors.get(ball) != color) {
                    ballColors.put(ball, color);
                    distinctColors.add(color);
                }
            } else {
                // If the ball is colored for the first time
                ballColors.put(ball, color);
                distinctColors.add(color);
            }
            
            // The number of distinct colors is the size of the set
            result[i] = distinctColors.size();
        }
        
        return result;
    }
}
