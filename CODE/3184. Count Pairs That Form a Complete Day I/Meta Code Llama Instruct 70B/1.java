class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int hour : hours) {
            int remainingHour = 24 - hour;
            if (map.containsKey(remainingHour)) {
                count += map.get(remainingHour);
            }
            map.put(hour, map.getOrDefault(hour, 0) + 1);
        }
        return count;
    }
}
