import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Step 1: Sort meetings based on the start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Merge intervals
        int mergedCount = 0;
        int[][] mergedMeetings = new int[meetings.length][2];
        
        for (int i = 0; i < meetings.length; i++) {
            if (mergedCount == 0 || mergedMeetings[mergedCount - 1][1] < meetings[i][0]) {
                // No overlap, add the current meeting
                mergedMeetings[mergedCount++] = meetings[i];
            } else {
                // Overlapping intervals, merge them
                mergedMeetings[mergedCount - 1][1] = Math.max(mergedMeetings[mergedCount - 1][1], meetings[i][1]);
            }
        }
        
        // Step 3: Count the free days
        int freeDays = 0;
        int currentDay = 1;
        
        for (int i = 0; i < mergedCount; i++) {
            // Count free days before the current merged meeting interval
            if (currentDay < mergedMeetings[i][0]) {
                freeDays += mergedMeetings[i][0] - currentDay;
            }
            // Move the current day to the end of the current merged interval + 1
            currentDay = Math.max(currentDay, mergedMeetings[i][1] + 1);
        }
        
        // Add the remaining free days after the last meeting
        if (currentDay <= days) {
            freeDays += days - currentDay + 1;
        }
        
        return freeDays;
    }
}
