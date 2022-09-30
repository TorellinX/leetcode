/*
125. Valid Palindrome
Easy
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric c
haracters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
 */
package ValidPalindrome;

public class ValidPalindrome {

  public boolean isPalindrome(String s) {
    s = (s.trim()).toLowerCase();
    int length = s.length();
    if (length < 2) {
      return true;
    }
    int l = 0;
    int r = length - 1;
    while (l < r) {
      if (!Character.isLetterOrDigit(s.charAt(l))) {
        l++;
        continue;
      }

      if (!Character.isLetterOrDigit(s.charAt(r))) {
        r--;
        continue;
      }

      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

}
