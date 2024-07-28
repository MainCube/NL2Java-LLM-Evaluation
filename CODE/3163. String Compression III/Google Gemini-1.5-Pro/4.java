class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        int i = 0; // Index to traverse the word
        while (i < word.length()) {
            char c = word.charAt(i); // Current character
            int count = 0; // Count of consecutive occurrences of c
            // Count consecutive occurrences of the current character
            while (i < word.length() && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            comp.append(count).append(c); // Append count and character to the compressed string
        }
        return comp.toString();
    }
}