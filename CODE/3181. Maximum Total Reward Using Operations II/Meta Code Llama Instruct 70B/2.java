class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int currentReward = 0;
        int maxReward = 0;
        
        for (int i = 0; i < rewardValues.length; i++) {
            if (rewardValues[i] > currentReward) {
                currentReward += rewardValues[i];
                maxReward = Math.max(maxReward, currentReward);
            }
        }
        
        return maxReward;
    }
}