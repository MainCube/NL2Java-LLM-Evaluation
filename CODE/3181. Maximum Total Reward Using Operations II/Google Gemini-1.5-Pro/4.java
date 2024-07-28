import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        
        // Sort the reward values in ascending order.
        Arrays.sort(rewardValues);
        
        // Initialize the total reward and a pointer to the largest reward.
        int totalReward = 0;
        int i = n - 1;
        
        // Iterate through the sorted rewards from largest to smallest.
        while (i >= 0) {
            // If the current reward is greater than the total reward,
            // add it to the total reward and move to the next smaller reward.
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
                i--;
            } else {
                // Otherwise, we cannot collect any more rewards, so break the loop.
                break;
            }
        }
        
        // Return the maximum total reward.
        return totalReward;
    }
}