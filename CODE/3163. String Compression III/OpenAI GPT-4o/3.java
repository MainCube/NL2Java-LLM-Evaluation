class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        
        int i = 0;
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;
            
            // Count up to 9 occurrences of the same character
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            
            // Append the count followed by the character to the compressed string
            comp.append(count).append(currentChar);
        }
        
        return comp.toString();
    }
}
