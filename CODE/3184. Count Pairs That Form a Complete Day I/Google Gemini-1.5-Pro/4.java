class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count = 0; // Initialize count of complete day pairs

        // Iterate through the array to consider each element as 'i'
        for (int i = 0; i < hours.length - 1; i++) {
            // Iterate through the remaining elements to consider each as 'j'
            for (int j = i + 1; j < hours.length; j++) {
                // Check if the sum of hours at indices i and j is divisible by 24
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++; // If divisible by 24, it forms a complete day, increment count
                }
            }
        }

        return count; // Return the total count of complete day pairs
    }
}