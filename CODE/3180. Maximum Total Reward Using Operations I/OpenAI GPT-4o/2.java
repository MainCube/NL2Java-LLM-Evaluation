import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Sort the reward values to facilitate the greedy approach
        Arrays.sort(rewardValues);
        
        // Initialize the total reward to 0
        int totalReward = 0;
        
        // Iterate through the sorted array and accumulate the reward
        for (int reward : rewardValues) {
            if (reward > totalReward) {
                totalReward += reward;
            }
        }
        
        return totalReward;
    }
}