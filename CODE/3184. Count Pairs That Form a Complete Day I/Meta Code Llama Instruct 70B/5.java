class Solution {
public int countCompleteDayPairs(int[] hours) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int hour : hours) {
        int remaining = 24 - hour;
        if (map.containsKey(remaining)) {
            count += map.get(remaining);
        }
        map.put(hour, map.getOrDefault(hour, 0) + 1);
    }
    return count;
}
}