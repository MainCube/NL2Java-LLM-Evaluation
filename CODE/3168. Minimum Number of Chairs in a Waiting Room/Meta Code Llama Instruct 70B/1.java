class Solution {
    public int minimumChairs(String s) {
        int chairsNeeded = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                chairsNeeded++;
            } else {
                chairsNeeded--;
            }
            if (chairsNeeded < 0) {
                chairsNeeded = Math.abs(chairsNeeded) + chairsNeeded;
            }
        }
        return chairsNeeded;
    }
}
