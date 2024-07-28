class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int count = 0;
        int prevEnd = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > prevEnd) {
                count += meeting[0] - prevEnd;
            }
            prevEnd = Math.max(prevEnd, meeting[1]);
        }
        if (days > prevEnd) {
            count += days - prevEnd;
        }
        return count;
    }
}
