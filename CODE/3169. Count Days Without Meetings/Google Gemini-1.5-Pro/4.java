class Solution {
    public int countDays(int days, int[][] meetings) {
        // Create a boolean array to track busy days.
        boolean[] busyDays = new boolean[days + 1]; // Index 0 is unused.

        // Mark days with meetings as busy.
        for (int[] meeting : meetings) {
            for (int day = meeting[0]; day <= meeting[1]; day++) {
                busyDays[day] = true;
            }
        }

        // Count the number of free days.
        int freeDays = 0;
        for (int day = 1; day <= days; day++) {
            if (!busyDays[day]) {
                freeDays++;
            }
        }

        return freeDays;
    }
}