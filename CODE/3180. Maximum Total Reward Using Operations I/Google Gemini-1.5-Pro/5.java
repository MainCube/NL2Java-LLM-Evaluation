import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        
        // Sort the reward values in ascending order.
        Arrays.sort(rewardValues);
        
        // Initialize the total reward and a pointer to the largest available reward.
        int totalReward = 0;
        int i = 0;
        
        // Iterate through the sorted rewards.
        while (i < n) {
            // If the current reward is greater than the total reward, 
            // we can collect it and update the total reward.
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
                i++; // Move to the next reward.
            } else {
                // If the current reward is not greater than the total reward,
                // we cannot collect it. We need to find the next larger reward.
                // Since the array is sorted, we can skip the current reward and continue.
                i++;
            }
        }
        
        return totalReward;
    }
}