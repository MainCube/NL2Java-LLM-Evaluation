class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        int[] colors = new int[limit + 1];
        int n = queries.length;
        int distinctColors = 0;
        
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if (colors[ball] == 0) {
                distinctColors++;
            }
            
            colors[ball] = color;
            result[i] = distinctColors;
        }
        
        return result;
    }
}
