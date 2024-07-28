class Solution {
    public int numberOfChild(int n, int k) {
        if(k % (2*(n-1)) == 0)
            return 0;
        k = k % (2*(n-1));
        if(k <= n-1)
            return k;
        else
            return 2*(n-1) - k;
    }
}
