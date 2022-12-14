/*
108. Convert Sorted Array to Binary Search Tree
Easy
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-
balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
never differs by more than one.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in a strictly increasing order.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
package ConvertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] nums) {
    return devideArray(nums, 0, nums.length - 1);
  }

  private TreeNode devideArray(int[] nums, int from, int to) {
    TreeNode tree = new TreeNode();
    int length = to - from + 1;
    if (length == 1) {
      tree.val = nums[from];
      tree.left = null;
      tree.right = null;
    } else if (length > 1) {
      int pivot = (length)/2 + from;
      tree.val = nums[pivot];
      if (pivot != from) {
        tree.left = devideArray(nums, from, pivot - 1);
      }
      if (pivot != to) {
        tree.right = devideArray(nums, pivot + 1, to);
      }
    } else {
      tree = null;
    }
    return tree;
  }

}
