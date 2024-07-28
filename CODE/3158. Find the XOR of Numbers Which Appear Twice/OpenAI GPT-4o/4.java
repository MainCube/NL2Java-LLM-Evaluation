import java.util.HashMap;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Step 1: Count the frequency of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Identify numbers that appear exactly twice and compute their XOR
        int xorResult = 0;
        boolean hasDuplicate = false;
        
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 2) {
                xorResult ^= num;
                hasDuplicate = true;
            }
        }
        
        // Step 3: Return the XOR result or 0 if no duplicates found
        return hasDuplicate ? xorResult : 0;
    }
}
