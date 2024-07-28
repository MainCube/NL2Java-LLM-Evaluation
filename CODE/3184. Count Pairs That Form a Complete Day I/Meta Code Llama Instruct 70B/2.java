class Solution {
public int countCompleteDayPairs(int[] hours) {
    Arrays.sort(hours);
    int left = 0;
    int right = hours.length - 1;
    int count = 0;
    while (left < right) {
        if (hours[left] + hours[right] > 24) {
            right--;
        } else if (hours[left] + hours[right] < 24) {
            left++;
        } else {
            count++;
            left++;
            right--;
        }
    }
    return count;
}
}