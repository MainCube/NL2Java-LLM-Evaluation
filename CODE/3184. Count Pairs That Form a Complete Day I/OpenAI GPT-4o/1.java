import java.util.HashMap;

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        
        // Count occurrences of each remainder
        for (int hour : hours) {
            int remainder = hour % 24;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        int pairCount = 0;
        
        // Process each unique remainder
        for (int r = 0; r < 24; r++) {
            if (remainderCount.containsKey(r)) {
                int complement = (24 - r) % 24;
                if (complement == r) {
                    // Special case: pairs within the same remainder group
                    int count = remainderCount.get(r);
                    pairCount += count * (count - 1) / 2;
                } else if (r < complement) {
                    // General case: pairs with different remainders
                    int count1 = remainderCount.get(r);
                    int count2 = remainderCount.getOrDefault(complement, 0);
                    pairCount += count1 * count2;
                }
            }
        }
        
        return pairCount;
    }
}
