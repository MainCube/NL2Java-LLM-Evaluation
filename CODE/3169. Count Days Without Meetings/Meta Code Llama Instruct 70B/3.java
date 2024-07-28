class Solution {
public int countDays(int days, int[][] meetings) {
int[] schedule = new int[days + 1];

    // Mark the days that have meetings scheduled
    for (int[] meeting: meetings) {
        for (int day = meeting[0]; day <= meeting[1]; day++) {
            schedule[day] = 1;
        }
    }
    
    int count = 0;
    for (int day = 1; day <= days; day++) {
        if (schedule[day] == 0) {
            count++;
        }
    }
    
    return count;
}


}