import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int totalReward = 0;

        // Sort the reward values in ascending order
        Arrays.sort(rewardValues);

        // Iterate through the sorted reward values
        for (int i = n - 1; i >= 0; i--) {
            // If the current reward value is greater than the total reward,
            // add it to the total reward
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
            }
        }

        return totalReward;
    }
}