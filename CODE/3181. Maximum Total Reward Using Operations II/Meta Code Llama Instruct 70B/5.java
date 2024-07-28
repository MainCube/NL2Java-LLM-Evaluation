class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Sort the reward values in descending order
        Arrays.sort(rewardValues);
        int totalReward = 0;
        
        // Iterate through the sorted reward values
        for (int reward : rewardValues) {
            // If the current reward value is greater than the total reward, add it to the total reward
            if (reward > totalReward) {
                totalReward += reward;
            }
        }
        
        return totalReward;
    }
}
