class Solution {
    public int minimumChairs(String s) {
        // Initialize the maximum number of chairs needed and the current number of people in the waiting room.
        int maxChairs = 0;
        int currentPeople = 0;

        // Iterate through each event in the string.
        for (int i = 0; i < s.length(); i++) {
            // If a person enters the waiting room, increment the current number of people.
            if (s.charAt(i) == 'E') {
                currentPeople++;
            } else { // If a person leaves the waiting room, decrement the current number of people.
                currentPeople--;
            }
            // Update the maximum number of chairs needed if the current number of people is greater.
            maxChairs = Math.max(maxChairs, currentPeople);
        }

        // Return the maximum number of chairs needed.
        return maxChairs;
    }
}