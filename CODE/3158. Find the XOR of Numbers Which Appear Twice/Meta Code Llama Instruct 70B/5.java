class Solution {
    public int duplicateNumbersXOR(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    // Store the count of each number in the HashMap
    for(int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int result = 0;

    // Calculate the bitwise XOR of all numbers that appear twice
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(entry.getValue() == 2) {
            result ^= entry.getKey();
        }
    }

    return result;


    }
}