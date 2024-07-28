class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;
        
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            // Count the number of repeated characters up to 9
            while (i < n && word.charAt(i) == c && count < 9) {
                i++;
                count++;
            }
            // Append the count followed by the character
            comp.append(count).append(c);
        }
        
        return comp.toString();
    }
}
