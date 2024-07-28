import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int totalReward = 0;
        
        for (int reward : rewardValues) {
            if (reward > totalReward) {
                totalReward += reward;
            }
        }
        
        return totalReward;
    }
}
