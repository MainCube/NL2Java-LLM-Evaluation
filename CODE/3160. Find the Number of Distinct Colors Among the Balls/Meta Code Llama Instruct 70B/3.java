class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Set<Integer> colors = new HashSet<>();

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (!colors.contains(color)) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i - 1];
            }

            colors.add(color);
        }

        return result;
    }
}
