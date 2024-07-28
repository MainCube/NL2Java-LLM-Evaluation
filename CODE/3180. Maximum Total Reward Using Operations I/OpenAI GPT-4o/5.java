import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Step 1: Sort the reward values
        Arrays.sort(rewardValues);
        
        // Step 2: Initialize total reward x
        int totalReward = 0;
        
        // Step 3: Iterate through the sorted reward values
        for (int reward : rewardValues) {
            if (reward > totalReward) {
                totalReward += reward;
            }
        }
        
        // Step 4: Return the maximum total reward
        return totalReward;
    }
}
