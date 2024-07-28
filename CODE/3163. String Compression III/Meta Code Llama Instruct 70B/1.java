class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(word.charAt(i - 1));
                count = 1;
            }
        }
        if (n > 0) {
            sb.append(count);
            sb.append(word.charAt(n - 1));
        }
        return sb.toString();
    }
}
