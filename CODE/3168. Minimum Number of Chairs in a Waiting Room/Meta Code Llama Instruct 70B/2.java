class Solution {
    public int minimumChairs(String s) {
        int maxChairs = 0;
        int currentChairs = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                currentChairs++;
            } else {
                currentChairs--;
            }
            
            maxChairs = Math.max(maxChairs, currentChairs);
        }
        
        return maxChairs;
    }
}