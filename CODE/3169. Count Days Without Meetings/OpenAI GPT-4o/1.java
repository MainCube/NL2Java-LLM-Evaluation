import java.util.HashSet;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Using a HashSet to store all the days with meetings
        HashSet<Integer> meetingDays = new HashSet<>();
        
        // Add all meeting days to the set
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            for (int i = start; i <= end; i++) {
                meetingDays.add(i);
            }
        }
        
        // Count the number of days without meetings
        int freeDays = 0;
        for (int day = 1; day <= days; day++) {
            if (!meetingDays.contains(day)) {
                freeDays++;
            }
        }
        
        return freeDays;
    }
}
