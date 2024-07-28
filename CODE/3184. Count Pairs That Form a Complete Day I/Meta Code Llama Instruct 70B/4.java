class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int hour : hours) {
            int remainingHour = 24 - hour;
            if (remainingHour > 0 && map.containsKey(remainingHour)) {
                result += map.get(remainingHour);
            }
            map.put(hour, map.getOrDefault(hour, 0) + 1);
        }
        return result;
    }
}
