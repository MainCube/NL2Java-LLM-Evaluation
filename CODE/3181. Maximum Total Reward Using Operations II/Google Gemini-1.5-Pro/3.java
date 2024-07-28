import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        
        // Sort the reward values in ascending order.
        Arrays.sort(rewardValues);
        
        // Initialize the total reward and a pointer to the largest reward.
        int totalReward = 0;
        int i = n - 1;

        // Iterate through the sorted rewards in descending order.
        while (i >= 0) {
            // If the current reward is greater than the total reward, 
            // add it to the total reward.
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
            } else {
                // Otherwise, we've reached a point where no more rewards can be added.
                break;
            }
            // Move to the next smaller reward.
            i--;
        }

        // Return the maximum total reward.
        return totalReward;
    }
}