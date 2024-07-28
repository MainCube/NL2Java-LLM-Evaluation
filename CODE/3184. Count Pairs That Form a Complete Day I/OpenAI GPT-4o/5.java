class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int count = 0;
        
        // Nested loop to check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if the sum of hours[i] and hours[j] is a multiple of 24
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
