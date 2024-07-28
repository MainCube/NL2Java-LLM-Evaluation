class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length]; // Array to store the results
        Set<Integer> colors = new HashSet<>(); // Set to keep track of distinct colors

        // Iterate through each query
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0]; // Get the ball index
            int color = queries[i][1]; // Get the color

            colors.add(color); // Add the color to the set (automatically handles duplicates)

            result[i] = colors.size(); // Store the number of distinct colors after this query
        }

        return result;
    }
}