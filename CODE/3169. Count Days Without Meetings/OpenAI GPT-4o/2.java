class Solution {
    public int countDays(int days, int[][] meetings) {
        // Create an array to keep track of busy days
        boolean[] isBusy = new boolean[days + 1];
        
        // Mark the days with meetings as busy
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            for (int i = start; i <= end; i++) {
                isBusy[i] = true;
            }
        }
        
        // Count the number of days that are not busy
        int freeDaysCount = 0;
        for (int i = 1; i <= days; i++) {
            if (!isBusy[i]) {
                freeDaysCount++;
            }
        }
        
        return freeDaysCount;
    }
}
