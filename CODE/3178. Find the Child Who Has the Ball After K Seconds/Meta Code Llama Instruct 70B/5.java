class Solution {
    public int numberOfChild(int n, int k) {
        int child = 0;
        for(int i = 1; i <= k; i++) {
            if(i % 2 == 1) {
                child = (child + 1) % n;
            } else {
                child = (child + n - 1) % n;
            }
        }
        return child;
    }
}
