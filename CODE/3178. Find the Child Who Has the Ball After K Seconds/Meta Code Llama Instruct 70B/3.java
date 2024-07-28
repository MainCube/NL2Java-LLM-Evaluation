class Solution {
    public int numberOfChild(int n, int k) {
        int child = 0;
        int direction = 1;
        for(int i = 1; i <= k; i++) {
            child += direction;
            if(child == 0 || child == n - 1) {
                direction *= -1;
            }
        }
        return child;
    }
}
