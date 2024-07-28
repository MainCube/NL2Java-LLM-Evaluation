class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        
        for(int num : nums) {
            int remainder = num % 3;
            map.put(remainder, map.get(remainder) + 1);
        }
        
        int minOperations = Math.min(map.get(1), map.get(2));
        return minOperations;
    }
}
