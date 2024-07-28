class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Set<Integer> colors = new HashSet<>(); // Track distinct colors used

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0]; // Get the ball index
            int color = queries[i][1]; // Get the color to apply

            colors.add(color); // Add the color (automatically handles duplicates)
            result[i] = colors.size(); // Store the count of distinct colors
        }

        return result;
    }
}