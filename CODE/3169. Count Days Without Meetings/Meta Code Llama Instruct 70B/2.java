class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int count = 0;
        int start = 1;

        for (int[] meeting : meetings) {
            if (meeting[0] > start) {
                count += meeting[0] - start;
            }
            start = Math.max(start, meeting[1] + 1);
        }

        return count + days - start;
    }
}