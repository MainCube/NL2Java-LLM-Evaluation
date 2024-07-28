class Solution {
    public int minimumOperations(int[] nums) {
        int countDivisibleBy3 = 0;
        int countOneMoreThanMultipleOf3 = 0;
        int countTwoMoreThanMultipleOf3 = 0;

        for (int num : nums) {
            if (num % 3 == 0) {
                countDivisibleBy3++;
            } else if (num % 3 == 1) {
                countOneMoreThanMultipleOf3++;
            } else {
                countTwoMoreThanMultipleOf3++;
            }
        }

        return Math.min(countDivisibleBy3 + countOneMoreThanMultipleOf3, countDivisibleBy3 + countTwoMoreThanMultipleOf3);
    }
}
