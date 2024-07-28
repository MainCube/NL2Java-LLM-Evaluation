import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Handle edge case where there are no meetings
        if (meetings.length == 0) {
            return days;
        }

        // Sort meetings by start day to process them in order
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int busyDays = 0; // Counter for days occupied by meetings
        int lastMeetingEnd = 0; // Track the end day of the last processed meeting

        for (int[] meeting : meetings) {
            int meetingStart = meeting[0];
            int meetingEnd = meeting[1];

            // If the current meeting starts after the last one ends, there's a gap
            if (meetingStart > lastMeetingEnd) {
                busyDays += (Math.min(meetingEnd, days) - lastMeetingEnd); 
            } else if (meetingEnd > lastMeetingEnd) {
                // Overlapping meetings: only count the non-overlapping portion
                busyDays += (meetingEnd - lastMeetingEnd);
            }

            lastMeetingEnd = Math.max(lastMeetingEnd, meetingEnd); // Update the last meeting's end day
        }

        // If the last meeting doesn't extend to the last day, count remaining days
        if (lastMeetingEnd < days) {
            busyDays += (days - lastMeetingEnd);
        }

        // Total available days minus busy days gives us the free days
        return days - busyDays;
    }
}