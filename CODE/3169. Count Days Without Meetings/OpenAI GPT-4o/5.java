class Solution {
    public int countDays(int days, int[][] meetings) {
        boolean[] available = new boolean[days];
        // Initialize all days as available
        for (int i = 0; i < days; i++) {
            available[i] = true;
        }
        
        // Mark days with meetings as unavailable
        for (int[] meeting : meetings) {
            int start = meeting[0] - 1; // Adjust for 0-based indexing
            int end = meeting[1] - 1; // Adjust for 0-based indexing
            for (int i = start; i <= end; i++) {
                available[i] = false;
            }
        }
        
        // Count the number of available days
        int count = 0;
        for (boolean isAvailable : available) {
            if (isAvailable) {
                count++;
            }
        }
        
        return count;
    }
}
