class Solution {
    public int countDays(int days, int[][] meetings) {
        // Create a boolean array to track days with meetings.
        boolean[] scheduled = new boolean[days + 1]; // Index 0 is unused.

        // Mark days with meetings.
        for (int[] meeting : meetings) {
            for (int day = meeting[0]; day <= meeting[1]; day++) {
                scheduled[day] = true;
            }
        }

        // Count days without meetings.
        int count = 0;
        for (int day = 1; day <= days; day++) {
            if (!scheduled[day]) {
                count++;
            }
        }

        return count;
    }
}