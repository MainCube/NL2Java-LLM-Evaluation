class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count = 0; // Initialize a counter for complete day pairs

        // Iterate through the array using nested loops to compare all pairs
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                // Check if the sum of hours at indices i and j is divisible by 24
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++; // If divisible by 24, it forms a complete day, so increment the count
                }
            }
        }

        return count; // Return the total count of complete day pairs
    }
}