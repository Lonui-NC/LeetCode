import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST1(TreeNode root) {
        // 同理进行问题的分解，搜索二叉树的左右子树也是搜索二叉树
        // 分别进行判断到最小的值和部分！
        if (root == null) {
            return true;
        }

        // 判断左右子树是否为二叉搜索树
        // 同时判断当前值是否满足条件
        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }

        // 保证左节点的值 > 当前节点 且 右节点的值 < 当前节点
        if (root.left != null && root.left.val >= root.val) {
            return false;
        } else if (root.right != null && root.right.val <= root.val) {
            return false;
        }
    }

    // 其实还有一个方法 - 二叉搜索树的中序遍历是一个递增序列！
    public boolean isValidBST(TreeNode root) {
        List<Integer> midOrderResult = midOrder(root);
        // 判断是否为递增序列
        int size = midOrderResult.size();
        for (int i = 0; i < size - 1; i++) {
            if (midOrderResult.get(i) >= midOrderResult.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // 遍历获取中序遍历，然后比较大小
    public List<Integer> midOrder(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        result.addAll(midOrder(root.left));
        result.add(root.val);
        result.addAll(midOrder(root.right));
        return result;  
    }

    // 方法 1 - 通过递归方法来实现 - 构造一个额外的函数用来做判断
    // 需要加上上限和下限
    // 函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。
    // helper(root.left, lower, root.val)
    // helper(root.right, root.val, upper)
    // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    public boolean isValidBST2(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = - Double.MAX_VALUE;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            // 一次遍历，不用再额外构造
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
// @lc code=end

