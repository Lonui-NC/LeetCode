import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
class Solution {
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) {
      return result;
    }
    result.addAll(inorderTraversal(root.left));
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));
    return result;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    while(!stack.isEmpty() || root != null) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      result.add(root.val);
      root = root.right;
    }

    return result;

  }
}