class Solution {
    public int waysToReachStair(int k) {
        // For k=0, Alice has exactly 2 ways to reach stair 0
        if (k == 0) {
            return 2;
        }
        // For k=1, Alice has exactly 4 ways to reach stair 1
        if (k == 1) {
            return 4;
        }
        // For k >= 2, the number of ways follows the combinatorial expansion
        // leading to powers of 2:
        return (int) Math.pow(2, k + 1);
    }
}
