class Solution {
    public int minimumChairs(String s) {
        int maxChairsNeeded = 0;
        int chairsNeeded = 0;
        
        for(char c : s.toCharArray()){
            if(c == 'E'){
                chairsNeeded++;
                maxChairsNeeded = Math.max(maxChairsNeeded, chairsNeeded);
            }
            else{
                chairsNeeded--;
            }
        }
        
        return maxChairsNeeded;
    }
}