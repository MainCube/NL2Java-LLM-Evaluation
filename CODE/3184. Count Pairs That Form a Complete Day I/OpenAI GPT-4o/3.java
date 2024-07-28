class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        
        // Count occurrences of each remainder when divided by 24
        for (int h : hours) {
            count[h % 24]++;
        }
        
        int totalPairs = 0;
        
        // Calculate pairs where i < j and (hours[i] + hours[j]) % 24 == 0
        for (int i = 0; i < 24; i++) {
            for (int j = i + 1; j < 24; j++) {
                if ((i + j) % 24 == 0) {
                    totalPairs += count[i] * count[j];
                }
            }
        }
        
        return totalPairs;
    }
}
