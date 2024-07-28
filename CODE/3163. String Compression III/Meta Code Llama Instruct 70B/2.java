class Solution {
public String compressedString(String word) {
StringBuilder sb = new StringBuilder();
int count = 0;
char prev = word.charAt(0);

    for (int i = 0; i < word.length(); i++) {
        char curr = word.charAt(i);
        
        if (curr == prev) {
            count++;
        } else {
            sb.append(count);
            sb.append(prev);
            prev = curr;
            count = 1;
        }
    }
    
    sb.append(count);
    sb.append(prev);
    
    return sb.toString();
}


}