/*
14. Longest Common Prefix
Easy
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
package LongestCommonPrefix;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    // String commonStr = "";
    for (int i = 0; i < strs[0].length(); i++) {
      char currentChar = strs[0].charAt(i);
      for (int strIndex = 1; strIndex < strs.length; strIndex++) {
        if (strs[strIndex].length() == i || strs[strIndex].charAt(i) != currentChar) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

}
