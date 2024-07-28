public class Solution {
    public int numberOfChild(int n, int k) {
        int position = 0; // Start at position 0
        boolean directionRight = true; // Start moving to the right

        for (int i = 0; i < k; i++) {
            if (directionRight) {
                position++;
                if (position == n - 1) {
                    directionRight = false;
                }
            } else {
                position--;
                if (position == 0) {
                    directionRight = true;
                }
            }
        }

        return position;
    }
}
