import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int totalReward = 0;

        // Sort the reward values in ascending order
        Arrays.sort(rewardValues);

        // Iterate through the sorted rewards
        for (int i = n - 1; i >= 0; i--) {
            // If the current reward is greater than the total reward,
            // add it to the total reward
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
            } else {
                // Since the rewards are sorted, if the current reward is
                // not greater than the total reward, any remaining rewards
                // will also not be greater. So, we can break the loop.
                break;
            }
        }

        // Return the maximum total reward
        return totalReward;
    }
}