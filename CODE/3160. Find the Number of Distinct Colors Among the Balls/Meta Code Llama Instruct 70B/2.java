class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Set<Integer> colors = new HashSet<>();
        Map<Integer, Integer> ballColors = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (!ballColors.containsKey(ball)) {
                colors.add(color);
            } else {
                colors.remove(ballColors.get(ball));
            }

            ballColors.put(ball, color);
            result[i] = colors.size();
        }

        return result;
    }
}
