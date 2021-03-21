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
  public List<Integer> postorderTraversal1(TreeNode root) {
    List<Integer> result = new LinkedList<>();
  
    if (root == null) {
      return result;
    }

    result.addAll(postorderTraversal(root.left));
    result.addAll(postorderTraversal(root.right));
    result.add(root.val);
    return result;
  }

  // 这道后序遍历的递归很是有意思
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> result = new LinkedList<>();

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;

    // 后序遍历的方法有些不同
    while(!stack.isEmpty() || root != null) {
      // 遍历左节点
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();

      // 这一步很关键，决定了为什么会不同 - 属于困难了！
      // root.right == prev 说明之前一个节点的左节点没有值，所以可以直接push！
      // 如果左节点有值，只能按同样方法再走一遍
      if (root.right == null || root.right == prev) {
        result.add(root.val);
        prev = root;
        // 这说明这个节点已经push完了，所以重新去掉！
        root = null;
      } else {
        // 这个在于找到最右边的节点，思路是对的，只是每个节点都走一遍左扫描
        stack.push(root);
        root = root.right;
      }

    }

    return result;
  }
}