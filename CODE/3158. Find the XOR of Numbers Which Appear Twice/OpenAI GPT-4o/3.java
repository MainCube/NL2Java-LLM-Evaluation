import java.util.HashMap;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Identify numbers that appear twice
        int xorResult = 0;
        boolean found = false;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == 2) {
                xorResult ^= key;
                found = true;
            }
        }

        // Step 3: Return the result
        return found ? xorResult : 0;
    }
}
