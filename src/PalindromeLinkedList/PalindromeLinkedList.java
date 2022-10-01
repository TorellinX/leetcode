/*
234. Palindrome Linked List
Easy
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
 */
/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */
package PalindromeLinkedList;

public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    // count the length
    int length = 1;
    ListNode curr = head;
    while (curr.next != null) {
      length++;
      curr = curr.next;
    }

    // set tail on the center + 1/2
    curr = head;
    for (int i = 0; i < (length + 1) / 2; i++) {
      curr = curr.next;
    }
    ListNode tail = curr;

    // REVERSE half of the list, at the end curr == center - 1/2
    curr = head;
    ListNode temp = curr.next;
    head.next = null;
    for (int i = 0; i < length / 2 - 1; i++) {
      head = curr;
      curr = temp;
      temp = curr.next;
      curr.next = head;
    }

    // check head == tail
    for (int i = 0; i < length / 2; i++) {
      if (curr.val != tail.val) {
        return false;
      }
      curr = curr.next;
      tail = tail.next;
    }
    return true;
  }

}
