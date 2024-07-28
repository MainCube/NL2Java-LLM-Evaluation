class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int startDay = 1, endDay = 1, count = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] >= endDay) {
                count += meeting[0] - endDay;
                endDay = meeting[1];
            } else if (meeting[1] > endDay) {
                endDay = meeting[1];
            }
        }
        if (endDay < days) {
            count += days - endDay;
        }
        return count;
    }
}
