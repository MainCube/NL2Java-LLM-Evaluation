class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int maxReward = 0;
        for (int reward : rewardValues) {
            if (reward > maxReward) {
                maxReward += reward;
            }
        }
        return maxReward;
    }
}
