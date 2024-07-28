import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        int completeDayPairs = 0;

        for (int hour : hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24; // Ensures complement is in the range 0-23

            // If complement exists, add the count of complement to completeDayPairs
            if (remainderCount.containsKey(complement)) {
                completeDayPairs += remainderCount.get(complement);
            }

            // Update the remainder count in the map
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return completeDayPairs;
    }
}
