class Solution {
    public int minimumChairs(String s) {
        // Initialize the maximum number of chairs needed and the current number of people in the waiting room.
        int maxChairs = 0;
        int currentPeople = 0;

        // Iterate through the string, simulating each event.
        for (int i = 0; i < s.length(); i++) {
            // If a person enters, increment the current number of people.
            if (s.charAt(i) == 'E') {
                currentPeople++;
            } 
            // If a person leaves, decrement the current number of people.
            else {
                currentPeople--;
            }
            
            // Update the maximum number of chairs needed if the current number of people is greater.
            maxChairs = Math.max(maxChairs, currentPeople);
        }

        // Return the maximum number of chairs needed.
        return maxChairs;
    }
}