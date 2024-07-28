import java.util.HashMap;
import java.util.Map;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        // Create a hashmap to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the occurrences of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the numbers that appear exactly twice
        int xorResult = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 2) {
                xorResult ^= entry.getKey();
            }
        }
        
        return xorResult;
    }
}