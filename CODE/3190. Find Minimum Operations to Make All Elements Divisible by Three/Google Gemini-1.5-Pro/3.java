class Solution {
	public int minimumOperations(int[] nums) {
	int count1 = 0; // Count of numbers with remainder 1 when divided by 3
	int count2 = 0; // Count of numbers with remainder 2 when divided by 3
	//Iterate through the array and count numbers with remainders 1 and 2
	for (int num : nums) {
	    if (num % 3 == 1) {
	        count1++;
	    } else if (num % 3 == 2) {
	        count2++;
	    }
	}
	
	// The minimum operations needed is the smaller of the two counts
	return Math.min(count1, count2) + Math.abs(count1 - count2);
	} 
}
