import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Step 1: Sort the rewardValues array
        Arrays.sort(rewardValues);
        
        // Step 2: Initialize the total reward x to 0
        int totalReward = 0;
        
        // Step 3: Iterate through the sorted rewardValues array
        for (int reward : rewardValues) {
            // If the reward is greater than the current total reward, add it to the total
            if (reward > totalReward) {
                totalReward += reward;
            }
        }
        
        // Return the maximum total reward we can collect
        return totalReward;
    }
}
