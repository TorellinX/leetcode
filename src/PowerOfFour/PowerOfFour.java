/*
342. Power of Four
Easy
Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true

Constraints:
-2^31 <= n <= 2^31 - 1

Follow up: Could you solve it without loops/recursion?
 */
package PowerOfFour;

public class PowerOfFour {

  public boolean isPowerOfFour1(int n) {
    if (n <= 0) {
      return false;
    } else {
      return Integer.bitCount(n) == 1 && Integer.numberOfTrailingZeros(n) % 2 == 0;
    }
  }

  public boolean isPowerOfFour2(int n) {
    if (n <= 0) {
      return false;
    } else {
      return ((n & (n - 1)) == 0) && Integer.numberOfTrailingZeros(n) % 2 == 0;
    }
  }

  public boolean isPowerOfFour3(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    // 0x55555555 == 1010101010101010101010101010101
  }

}
