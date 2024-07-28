class Solution {
    public int minimumChairs(String s) {
        int currentPeople = 0;
        int maxPeople = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                currentPeople++;
                if (currentPeople > maxPeople) {
                    maxPeople = currentPeople;
                }
            } else if (s.charAt(i) == 'L') {
                currentPeople--;
            }
        }
        
        return maxPeople;
    }
}
