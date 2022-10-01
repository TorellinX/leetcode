/*
383. Ransom Note
Easy
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the
letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 10^5
ransomNote and magazine consist of lowercase English letters.
 */
package RansomNote;

import java.util.HashMap;

public class RansomNote {

  public boolean canConstruct1(String ransomNote, String magazine) {
    int[] counter = new int[26];
    for (char c : magazine.toCharArray()) {
      counter[c - 'a']++;
    }
    for (char r : ransomNote.toCharArray()) {
      counter[r - 'a']--;
    }
    for (int count : counter) {
      if (count < 0) {
        return false;
      }
    }
    return true;
  }

  public boolean canConstruct2(String ransomNote, String magazine) {
    HashMap<Character, Integer> count = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }
    for (Character r : ransomNote.toCharArray()) {
      if (count.getOrDefault(r, 0) == 0) {
        return false;
      }
      count.put(r, count.getOrDefault(r, 0) - 1);
    }
    return true;
  }

}
