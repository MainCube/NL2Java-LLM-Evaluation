import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColors = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int distinctColors = 0;
        
        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];
            
            // Check the current color of the ball (if any)
            if (ballColors.containsKey(ball)) {
                int currentColor = ballColors.get(ball);
                if (currentColor != color) {
                    // Reduce the count of the current color
                    colorCount.put(currentColor, colorCount.get(currentColor) - 1);
                    if (colorCount.get(currentColor) == 0) {
                        distinctColors--;
                    }
                }
            }
            
            // Set the new color for the ball
            ballColors.put(ball, color);
            
            // Increase the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            if (colorCount.get(color) == 1) {
                distinctColors++;
            }
            
            // Record the current number of distinct colors
            result.add(distinctColors);
        }
        
        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
