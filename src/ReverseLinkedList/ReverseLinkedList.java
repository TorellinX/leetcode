/*
206. Reverse Linked List
Easy
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package ReverseLinkedList;

public class ReverseLinkedList {

  //iteratively
  public ListNode reverseListIteratively(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode curr = head;
    ListNode temp = curr.next;
    head.next = null;
    while (temp != null) {
      head = curr;
      curr = temp;
      temp = curr.next;
      curr.next = head;

    }
    return curr;
  }

  //recursively
  public ListNode reverseListRecursively(ListNode head) {
    // SOLUTION UNDERSTANDING

    if (head == null || head.next == null)      // v
      return head;                              // v
    ListNode reverse = reverseListRecursively(head.next);  // v

    head.next.next = head;               // !!!
    head.next = null;                    // !!!

    return reverse;                             // v
  }
}
