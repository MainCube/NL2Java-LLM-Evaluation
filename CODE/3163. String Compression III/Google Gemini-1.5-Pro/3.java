class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        int i = 0; // Index to traverse the word

        while (i < word.length()) {
            char currentChar = word.charAt(i); // Get the current character
            int count = 0; // Initialize count of consecutive occurrences

            // Count consecutive occurrences of the current character
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            // Append the count and character to the compressed string
            comp.append(count);
            comp.append(currentChar);
        }

        return comp.toString();
    }
}