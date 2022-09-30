/*
98. Validate Binary Search Tree
Medium
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
package ValidateBinarySearchTree;

public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
    return checkTree(root);
  }

  private boolean checkTree(TreeNode node) {
    int val = node.val;
    if (node.left == null && node.right == null) {
      return true;
    }
    if (node.left != null && !checkValLeft(val, node.left)) {
      return false;
    }
    if (node.right != null && !checkValRight(val, node.right)) {
      return false;
    }
    if (node.left != null && !checkTree(node.left)) {
      return false;
    }
    return node.right == null || checkTree(node.right);
  }

  private boolean checkValLeft(int val, TreeNode node) {
    if (node == null) {
      return true;
    }
    if (node.val >= val) {
      return false;
    }
    if (node.right == null) {
      return true;
    }
    return checkValLeft(val, node.right);
  }

  private boolean checkValRight(int val, TreeNode node) {
    if (node.val <= val) {
      return false;
    }
    if (node.left == null) {
      return true;
    }
    return checkValRight(val, node.left);
  }

}
