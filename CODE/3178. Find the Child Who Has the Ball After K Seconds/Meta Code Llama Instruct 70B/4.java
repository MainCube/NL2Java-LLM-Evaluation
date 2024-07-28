class Solution {
    public int numberOfChild(int n, int k) {
        int child = 0;
        int cycles = k / (2 * n - 2);
        int remainingSeconds = k % (2 * n - 2);
        
        if (cycles % 2 == 1) {
            child = n - 1;
        }
        
        child = (child + remainingSeconds) % n;
        
        return child;
    }
}
