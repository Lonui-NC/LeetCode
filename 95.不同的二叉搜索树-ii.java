import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    // * 回溯法！！
    // 假设当前序列长度为 nn，如果我们枚举根节点的值为 ii，
    // 那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1 \ldots i-1][1…i−1]，
    // 右子树的节点值的集合为 [i+1 \ldots n][i+1…n]。而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，
    // 因此我们可以想到用回溯的方法来解决这道题目。
    public List<TreeNode> generateTrees(int start, int end) {
        // end < start 表示终结，没有节点可以返回，返回null
        List<TreeNode> result = new LinkedList<>();
        if (end < start) {
            // 这里其实做了边缘条件的处理, 不合法返回空节点
            // 可以认为数组元素都被使用，超出了边界
            result.add(null);
            return result;
        }
        List<TreeNode> leftTrees;
        List<TreeNode> rightTrees;

        // 前后都需要
        for (int i=start; i <= end; i++) {
            leftTrees = generateTrees(start, i-1);
            rightTrees = generateTrees(i+1, end);
            for (TreeNode l : leftTrees) {
                for (TreeNode r: rightTrees) {
                    // curNode每次都要新生成 -> 不能冲突
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = l;
                    curNode.right = r;
                    result.add(curNode);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
}
// @lc code=end

