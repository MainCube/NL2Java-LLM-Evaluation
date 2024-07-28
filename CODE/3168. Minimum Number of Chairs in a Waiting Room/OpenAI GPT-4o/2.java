class Solution {
    public int minimumChairs(String s) {
        int currentPeople = 0;
        int maxPeople = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                currentPeople++;
                if (currentPeople > maxPeople) {
                    maxPeople = currentPeople;
                }
            } else if (c == 'L') {
                currentPeople--;
            }
        }
        
        return maxPeople;
    }
}
