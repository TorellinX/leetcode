/*
485. Max Consecutive Ones
Easy
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
 */
package MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxSequence = 0;
    int currentSequence = 0;
    for (int number : nums) {
      if (number == 1) {
        currentSequence++;
      } else {
        if (currentSequence > maxSequence) {
          maxSequence = currentSequence;
        }
        currentSequence = 0;
      }

    }
    if (currentSequence > maxSequence) {
      maxSequence = currentSequence;
    }
    return maxSequence;
  }

}
