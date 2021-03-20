import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
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
    // 需要心细一些，三个基础案例首先都要跑一遍
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 递归法判断是否相同
        if (p == null && q == null) {
            return true;
        // 空指针判断
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    // 方法1 - 深度优先搜索
    // 如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，
    // 若不相同则两个二叉树一定不同，若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。
    // 这是一个递归的过程，因此可以使用深度优先搜索，递归地判断两个二叉树是否相同。

    // 方法2 - 回溯 -> 用stack或者动态取出所有节点 -> 层序遍历然后再比较 - 广度优先搜索
    // Tips - 插入值
}
// @lc code=end

