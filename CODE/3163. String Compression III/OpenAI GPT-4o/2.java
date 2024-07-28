class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;

        while (i < n) {
            char c = word.charAt(i);
            int count = 0;

            // Count the number of consecutive characters 'c', but not more than 9
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