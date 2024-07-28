class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalPairs = 0;
        
        for (int hour : hours) {
            int complementaryHour = 24 - hour;
            if (map.containsKey(complementaryHour)) {
                totalPairs += map.get(complementaryHour);
            }
            map.put(hour, map.getOrDefault(hour, 0) + 1);
        }
        
        return totalPairs;
    }
}
