import java.util.HashMap;

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        
        for (int hour : hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24;
            
            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }
            
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}