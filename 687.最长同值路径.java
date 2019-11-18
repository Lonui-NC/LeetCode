/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        
        // 之所以不这样是因为只能向最左和最右进行伸展，不能既向左伸展又向右伸展 多伸展几次
        // if (root.left != null && root.right !=null && root.val == root.left.val && root.val == root.right.val) {
        //     leftPath += 1;
        //     rightPath += 1;
        // }
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPath = arrowLength(node.left);
        int rightPath = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.val == node.left.val) {
            arrowLeft = leftPath + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            arrowRight = rightPath + 1;
        }
        // 如果都相等的话，证明左右都有值，那么就直接取对应的长度之和就可以！
        // 通过这个来计算单个节点的最大值
        ans = Math.max(ans, arrowLeft + arrowRight);
        // 同理，如果有值的话证明存在可扩展伸长的链
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end

