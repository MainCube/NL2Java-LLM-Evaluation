import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int x = 0;
        
        for (int reward : rewardValues) {
            if (reward > x) {
                x += reward;
            }
        }
        
        return x;
    }
}
