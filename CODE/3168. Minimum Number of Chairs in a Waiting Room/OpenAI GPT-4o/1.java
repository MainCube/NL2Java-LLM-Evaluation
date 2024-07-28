class Solution {
    public int minimumChairs(String s) {
        int current_people = 0;
        int max_people = 0;
        
        for (char event : s.toCharArray()) {
            if (event == 'E') {
                current_people++;
                if (current_people > max_people) {
                    max_people = current_people;
                }
            } else if (event == 'L') {
                current_people--;
            }
        }
        
        return max_people;
    }
}
