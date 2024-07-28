import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        
        // Sort the reward values in ascending order.
        Arrays.sort(rewardValues);
        
        // Initialize the total reward and a pointer to the last reward that can be collected.
        int totalReward = 0;
        int j = 0;
        
        // Iterate through the sorted reward values.
        for (int i = 0; i < n; i++) {
            // If the current reward value is greater than the total reward,
            // we can collect it and update the total reward.
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
                j = i + 1; // Update the pointer to the next reward.
            }
        }
        
        return totalReward;
    }
}