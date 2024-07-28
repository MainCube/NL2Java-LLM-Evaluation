class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i); // Get the current character
            int count = 0;
            // Count consecutive occurrences of the current character
            while (i < word.length() && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            comp.append(count); // Append the count
            comp.append(c); // Append the character
        }
        return comp.toString();
    }
}