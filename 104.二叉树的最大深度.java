/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    // 我们也可以用「广度优先搜索」的方法来解决这道题目，
    // 但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
    // 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，
    // 我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
    // 即我们是一层一层地进行拓展，最后我们用一个变量 \textit{ans}ans 来维护拓展的次数，
    // 该二叉树的最大深度即为 \textit{ans}ans。

    public int maxDepth(TreeNode root) {
        int res, resLeft, resRight;
        if (root == null) {
            return 0;
        }
        resLeft = maxDepth(root.left);
        resRight = maxDepth(root.right);
        res = Math.max(resLeft, resRight) + 1;
        return res;
    }
}
// @lc code=end

