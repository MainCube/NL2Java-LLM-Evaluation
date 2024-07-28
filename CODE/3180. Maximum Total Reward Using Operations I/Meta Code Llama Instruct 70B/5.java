class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int totalReward = 0;
        for (int i = rewardValues.length - 1; i >= 0; i--) {
            if (rewardValues[i] > totalReward) {
                totalReward += rewardValues[i];
            }
        }
        return totalReward;
    }
}
