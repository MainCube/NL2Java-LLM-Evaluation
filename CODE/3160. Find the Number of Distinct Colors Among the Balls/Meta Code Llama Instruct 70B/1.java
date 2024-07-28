class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Set<Integer> colors = new HashSet<>();
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            colors.add(queries[i][1]);
            result[i] = colors.size();
        }
        
        return result;
    }
}
