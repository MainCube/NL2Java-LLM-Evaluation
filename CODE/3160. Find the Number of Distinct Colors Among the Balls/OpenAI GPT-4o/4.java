import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorMap = new HashMap<>();
        Set<Integer> distinctColors = new HashSet<>();
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if (colorMap.containsKey(ball)) {
                int oldColor = colorMap.get(ball);
                if (oldColor != color) {
                    // If changing to a different color
                    colorMap.put(ball, color);
                    
                    // If the old color is no longer in use, remove it
                    if (!colorMap.containsValue(oldColor)) {
                        distinctColors.remove(oldColor);
                    }
                }
            } else {
                colorMap.put(ball, color);
            }
            
            distinctColors.add(color);
            result[i] = distinctColors.size();
        }
        
        return result;
    }
}
