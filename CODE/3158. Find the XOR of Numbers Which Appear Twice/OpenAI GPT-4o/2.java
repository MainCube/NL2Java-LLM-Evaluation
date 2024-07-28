import java.util.HashMap;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Count the occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int xorResult = 0;
        boolean hasDuplicates = false;
        
        // XOR all numbers that appear twice
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 2) {
                xorResult ^= num;
                hasDuplicates = true;
            }
        }
        
        // If there are no duplicates, return 0
        return hasDuplicates ? xorResult : 0;
    }
}