import java.util.ArrayDeque;
import java.util.ArrayList;
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
  // 基础1 - 递归法 —> 实现
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) {
      return result;
    }

    result.add(root.val);
    result.addAll(preorderTraversal(root.left));
    result.addAll(preorderTraversal(root.right));
    return result;
  }

  // 基础2 - 回溯法 -> 实现
  public List<Integer> preorderTraversal3(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      result.add(cur.val);
      stack.push(cur.right);
      stack.push(cur.left);
    }

    return result;
  }

  // 遍历法，与递归思路一样，区别在于需要自己实现栈。
  // 前序遍历，根节点在先： 根-左-右。
  // 时间复杂度O（n），空间复杂度O（n）。
  // 根节点 - 前序遍历是要遍历到最左
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    // 所以结束条件是root为null，且stack为空！ -> 证明没有元素了
    while(root != null || !stack.isEmpty()) { 
      // 这个的作用在于遍历完所有的root和root的left！
      while(root != null) {
        stack.push(root);
        // 永远先拿root的val
        result.add(root.val);
        root = root.left;
      }
      // 如果左边都遍历完，那么走右边的！
      root = stack.pop().right;
    }
    return result;
  }




}