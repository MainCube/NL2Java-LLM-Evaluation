class Solution {
    public int minOperations(int[] nums) {
        /*
         * The key observation is that we don't need to track the state of the entire array. 
         * We only need to track whether the prefix of the array up to the current index 
         * needs to be flipped or not.
         *
         * If the current element is 0 and the prefix doesn't need flipping, or the 
         * current element is 1 and the prefix needs flipping, we need to flip the array 
         * from the current index onwards. This constitutes one operation.
         */
        int operations = 0;
        boolean flipPrefix = false; // Initially, no need to flip

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == 0 && !flipPrefix) || (nums[i] == 1 && flipPrefix)) {
                // Flip the prefix from the current index onwards
                flipPrefix = !flipPrefix;
                operations++;
            } 
        }

        return operations;
    }
}