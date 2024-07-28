class Solution {
    public int countDays(int days, int[][] meetings) {
        boolean[] availability = new boolean[days];
        // Mark all days as available
        for (int i = 0; i < days; i++) {
            availability[i] = true;
        }
        // Mark days with meetings as unavailable
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0] - 1; // Adjust for 0-based indexing
            int end = meetings[i][1] - 1; // Adjust for 0-based indexing
            for (int j = start; j <= end; j++) {
                availability[j] = false;
            }
        }
        // Count available days
        int count = 0;
        for (int i = 0; i < days; i++) {
            if (availability[i]) {
                count++;
            }
        }
        return count;
    }
}
