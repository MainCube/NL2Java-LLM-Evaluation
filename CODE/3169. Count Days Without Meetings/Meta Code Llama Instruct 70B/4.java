class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int start = 1, end = 1;
        int availableDays = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > end) {
                availableDays += meeting[0] - end;
            }
            end = Math.max(end, meeting[1]);
        }
        if (end < days) {
            availableDays += days - end;
        }
        return availableDays;
    }
}
