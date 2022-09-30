/*
20. Valid Parentheses
Easy
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.
 */
package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stk = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stk.push(c);
        continue;
      }
      if (stk.empty()) {
        return false; // if the case above did not work, the stack should not be empty
      }
      char bracket = stk.peek();
      if (c == '}' && bracket == '{') {
        stk.pop();
        continue;
      }
      if (c == ']' && bracket == '[') {
        stk.pop();
        continue;
      }
      if (c == ')' && bracket == '(') {
        stk.pop();
        continue;
      } else {
        return false;
      }
    }
    return stk.empty();
  }

}
