class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Sort the rewardValues array in descending order
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        
        // Initialize the total reward x to 0
        int x = 0;
        
        // For each unmarked index i from the range [0, n - 1]
        for (int i = 0; i < n; i++) {
            // If rewardValues[i] is greater than x, then add rewardValues[i] to x (i.e., x = x + rewardValues[i]), and mark the index i
            if (rewardValues[i] > x) {
                x += rewardValues[i];
            }
        }
        
        // Return x, which is the maximum total reward you can collect
        return x;
    }
}
