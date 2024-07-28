class Solution {
    public int countDays(int days, int[][] meetings) {
        // Create a boolean array to track meeting days.
        boolean[] scheduled = new boolean[days + 1]; 

        // Mark days with meetings as scheduled.
        for (int[] meeting : meetings) {
            for (int day = meeting[0]; day <= meeting[1]; day++) {
                scheduled[day] = true;
            }
        }

        // Count the days without meetings.
        int count = 0;
        for (int day = 1; day <= days; day++) {
            if (!scheduled[day]) {
                count++;
            }
        }

        return count;
    }
}