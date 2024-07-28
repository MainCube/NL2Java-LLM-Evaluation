import java.util.HashMap;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int xorResult = 0;
        boolean found = false;
        
        // Find numbers that appear exactly twice and compute their XOR
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == 2) {
                xorResult ^= num;
                found = true;
            }
        }
        
        return found ? xorResult : 0;
    }
}
