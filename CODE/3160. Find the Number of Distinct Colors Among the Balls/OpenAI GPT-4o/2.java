import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Set<Integer> distinctColors = new HashSet<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if (ballToColor.containsKey(ball)) {
                int currentColor = ballToColor.get(ball);
                if (currentColor != color) {
                    distinctColors.remove(currentColor);
                    ballToColor.put(ball, color);
                    distinctColors.add(color);
                }
            } else {
                ballToColor.put(ball, color);
                distinctColors.add(color);
            }

            result[i] = distinctColors.size();
        }

        return result;
    }
}
