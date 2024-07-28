class Solution {
    public String compressedString(String word) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        char prev = '\0';
        for (char c : word.toCharArray()) {
            if (c != prev) {
                if (count > 0) {
                    compressed.append(count).append(prev);
                }
                count = 1;
                prev = c;
            } else {
                count++;
            }
        }
        if (count > 0) {
            compressed.append(count).append(prev);
        }
        return compressed.toString();
    }
}
