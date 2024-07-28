class Solution {
public int maxTotalReward(int[] rewardValues) {
Arrays.sort(rewardValues);
int maxReward = 0;
for (int i = rewardValues.length - 1; i >= 0; i--) {
if (rewardValues[i] > maxReward) {
maxReward += rewardValues[i];
}
}
return maxReward;
}
}