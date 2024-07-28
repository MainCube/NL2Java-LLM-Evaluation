class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();
        
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            
            // Count the consecutive occurrences of the character c, up to 9 times
            while (i < n && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            
            // Append the count and the character to the result
            comp.append(count).append(c);
        }
        
        return comp.toString();
    }
}
